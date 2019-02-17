import React from 'react';

export default function LoadingIndicator(props) {
  return (
    <div className="loading-indicator" style={{display: 'block', textAlign: 'center', marginTop: '30px'}}>
      読み込み中 ...
    </div>
  );
}