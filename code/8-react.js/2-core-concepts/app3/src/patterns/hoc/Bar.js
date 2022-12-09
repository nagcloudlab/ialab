import React from 'react';
import { withCard } from './withCard';

function Bar(props) {
    return (
        <div>
            im Bar component
            <button className='btn btn-primary'>click me</button>
        </div>
    );
}

export default withCard(Bar);