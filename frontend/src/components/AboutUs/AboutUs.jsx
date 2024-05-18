import Button from "../Button/Button";
import './AboutUs.css';
import {Link} from "react-router-dom";

export default function AboutUs() {
    return (
        <div className="about-us-container">
            <h1>Посветени на вашата грижа</h1>
            <p>Kindly ви пренесува мрежа од искусни локални негуватели, секој строго
                проверен и посветен на обезбедување квалитетна грижа. Со фокус на
                надежност и искрена посветеност кон доброто на вашите сакани, нашата
                апликација безпроблемно го надминува јазот помеѓу професионалните
                негуватели и потребите на вашето семејство.
            </p>
            <div className="btn-div">
                <Button>
                    <Link to={"/services"}>
                        Дознај Повеќе
                    </Link>
                </Button>
            </div>
        </div>
    );
}