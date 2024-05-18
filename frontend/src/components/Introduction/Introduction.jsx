import logo from '../../assets/logo.svg';
import Button from '../Button/Button';
import './Introduction.css';
import {Link} from "react-router-dom";

export default function Introduction() {
    return (
        <div className="introduction-container">
            <div className='info-container'>
                <img src={logo} alt="kindly logo" className='logo-img' />
                {/*<h1>Kindly</h1>*/}
                <p>Обединување на семејства со извондредни локални негуватели.</p>
                <Button>
                    <Link to={"/services"}>
                        Пронајдете грижа тука
                    </Link>
                </Button>
            </div>
            <div className='background-container'>
            </div>
        </div>
    );
}