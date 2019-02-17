import React, { Component } from 'react';
import { Link, NavLink } from 'react-router-dom';
import './AppHeader.css';

class AppHeader extends Component {
  render() {
    return (
      <header className="app-header">
        <div className="container">
          <div className="app-branding">
            <Link to="/" className="app-title">Hexaforce</Link>
          </div>
          <div className="app-options">
            <nav className="app-nav">{this.props.authenticated ? (
              <ul>
                <li>
                  <NavLink to="/profile">アカウント情報</NavLink>
                </li>
                <li>
                  <a onClick={this.props.onLogout}>ログアウト</a>
                </li>
              </ul>) : (
                <ul>
                  <li>
                    <NavLink to="/login">ログイン</NavLink>
                  </li>
                  <li>
                    <NavLink to="/signup">新規アカウント</NavLink>
                  </li>
                </ul>)}
            </nav>
          </div>
        </div>
      </header>
    )
  }
}

export default AppHeader;