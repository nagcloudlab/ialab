
import React from 'react';
import { withCard } from '../hoc/withCard'

function Foo(props) {
    return (
        <div>
            im Foo component
        </div>
    );
}

export default withCard(Foo); 