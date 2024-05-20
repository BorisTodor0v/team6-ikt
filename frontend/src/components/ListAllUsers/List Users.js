import React from 'react';
import UserTerm from "./Term";
class ListUsers extends React.Component {

    constructor(props) {
        super(props);
    }


    render() {
        const users = this.getUsers();
        return(
            <div>
                <ul>
                    {users}
                </ul>
            </div>
        )
    }

    getUsers = () => {
        return this.props.users.map((term, index) => {
            return (
                <UserTerm term={term}/>
            )
        })
    }

}
export default ListUsers;