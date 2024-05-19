import './Service.css';
import {Link} from "react-router-dom";

export default function Service({image, label, onClick}){
    return (
        <Link to={'/offers'} className='service-container' onClick={onClick}>
                <img src={image} alt="service image"/>
                <p className='service-label'>{label}</p>
        </Link>
    );
}