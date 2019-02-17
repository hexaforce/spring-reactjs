package io.hexaforce.petclinic.config;

import java.time.Duration;

import javax.cache.CacheManager;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableCaching
@Profile("production")
public class CacheConfig {

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        
        return new JCacheManagerCustomizer() {
            @Override
            public void customize(CacheManager cacheManager) {
                
                CacheConfiguration<Object, Object> config = CacheConfigurationBuilder.newCacheConfigurationBuilder(
                            Object.class, 
                            Object.class, 
                            ResourcePoolsBuilder.newResourcePoolsBuilder().heap(100, EntryUnit.ENTRIES)
                        )
                        .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(60)))
                        .build();
                
                cacheManager.createCache("vets", Eh107Configuration.fromEhcacheCacheConfiguration(config));
                
            }
        };
    }

}
