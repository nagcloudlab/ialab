import React from 'react';

function Header({ title }) {
    return (
        <div>
            <div className="display-1">{title}</div>
            <hr />
        </div>
    );
}

export default Header;