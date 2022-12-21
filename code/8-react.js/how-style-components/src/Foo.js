import React from 'react';

import styles from './Foo.module.css'

function Foo(props) {
    return (
        <div className={styles.card}>
            this is foo component
        </div>
    );
}

export default Foo;