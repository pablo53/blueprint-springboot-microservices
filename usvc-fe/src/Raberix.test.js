import React from 'react';
import ReactDOM from 'react-dom';
import Raberix from './Raberix';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<Raberix />, div);
});
