import React from "react";

const UserTerm = (props) => {
    return (
        <div>
            <li>
                {/*{props.term.id}. {props.term.username} - {props.term.name} {props.term.surname} - {props.term.role} - {props.term.email} - {props.term.address} - Rating: {props.term.grade}*/}
                {props.term.name} {props.term.surname} | minSalary - maxSalary | Rating: {props.term.grade}
                <br/>
                Trained in first aid | Has Car | Non Smoker
                <br/>
                {props.term.email}
            </li>
        </div>
    )
}

export default UserTerm;