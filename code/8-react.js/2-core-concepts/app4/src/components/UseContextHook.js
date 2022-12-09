import React, { useContext } from 'react';

// to keep current login user data
const UserContext = React.createContext()
// to keep current theme
const ThemeContext = React.createContext()

function UserProfile() {
    const user = useContext(UserContext)
    const theme = useContext(ThemeContext)
    return (
        <div className='alert alert-info'>
            {
                // <UserContext.Consumer>
                //     {user => {
                //         return (
                //             <ThemeContext.Consumer>
                //                 {theme => {
                //                     return (<span className={theme.bg}>{user.name},{user.location}</span>)
                //                 }}
                //             </ThemeContext.Consumer>
                //         )
                //     }}
                // </UserContext.Consumer>
            }
            <span className={theme.bg}>{user.name},{user.location}</span>
        </div>
    )
}

function Card() {
    return (
        <div className='card card-body'>
            <UserProfile />
        </div>
    )
}

function UseContextHook(props) {
    const user = {
        name: 'Nag',
        location: 'chennai'
    }
    const theme = {
        bg: 'bg-warning'
    }
    return (
        <div className='card'>
            <div className='card-header'>Context Hook</div>
            <div className='card-body'>
                <UserContext.Provider value={user}>
                    <ThemeContext.Provider value={theme}>
                        <Card />
                    </ThemeContext.Provider>
                </UserContext.Provider>
            </div>
        </div>
    );
}

export default UseContextHook;