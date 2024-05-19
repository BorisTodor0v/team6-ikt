import React from "react";
import './Term.css';
import star from '../../assets/rating-star.jpg';
import firstAid from '../../assets/first-aid-kit.png';
import car from '../../assets/car.png';
import noSmoke from '../../assets/no-smoke.png';
import education from '../../assets/mortarboard.png';
import pets from '../../assets/animal.png';

const UserTerm = (props) => {
    return (
        <div>
            <br/>
            <div class="card">
                <h2>{props.term.name} {props.term.surname}</h2>
                <p class="price">${props.term.minSalary} - ${props.term.maxSalary}</p>
                <p>
                    {props.term.trainedInFirstAid && <img src={firstAid} alt="Trained in first aid" className="trait-icon"/>}
                    {props.term.hasCar && <img src={car} alt="Has Car" className="trait-icon"/>}
                    {props.term.nonSmoker && <img src={noSmoke} alt="Non Smoker" className="trait-icon"/>}
                    {props.term.highEducation && <img src={education} alt="High education" className="trait-icon"/>}
                    {props.term.comfortableWithPets && <img src={pets} alt="Comfortable With Pets" className="trait-icon"/>}
                </p>
                <p>{props.term.email}</p>
                <p>
                    <span>Rating: {props.term.grade} </span>
                    <img src={star} alt="Star image" style={{width: "15px"}}></img>
                </p>
            </div>
            <br/>
        </div>
    )
}

export default UserTerm;