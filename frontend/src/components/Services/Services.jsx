import Service from '../Service/Service';
import './Services.css';
import childcare from '../../assets/child-care-icon.png';
import petcare from '../../assets/pet-care-icon.png';
import eldercare from '../../assets/elder-care-icon.png';

export default function Services({onSelect}) {

    const handleClick = (serviceIndex) => {
        if (onSelect) {
            onSelect(serviceIndex)
        }
    }

    return (
        <div className='services-container'>
            <h1>Наши Услуги</h1>
            <p className='services-info'>Kindly е специјализиран за обезбедување извонредни услуги за нега, со фокус
                на здравјето и потребите за семејна грижа.</p>
            <div className='services-buttons-container'>
                <Service image={childcare} label="Нега за деца" onClick={() => handleClick(1)}/>
                <Service image={eldercare} label="Нега за стари лица" onClick={() => handleClick(2)}/>
                <Service image={petcare} label="Нега за миленичиња" onClick={() => handleClick(3)}/>
            </div>
        </div>
    );
}