import React from "react";
import {Link} from "react-router-dom";
import nav from "./styles.css";

const Header = () => {

    return(
        <header>
            <nav className="nav">
                <Link to={"/"} className={"SiteLogo"}>
                    <img src={`${process.env.PUBLIC_URL}/images/logo.jpg`} alt="Kindly Logo" style={{width: "100px"}}/>
                </Link>
                <ul>
                    <li>
                        <Link to={"/"}>Дома</Link>
                    </li>
                    <li>
                        <Link to={"/users"}>Листај корисници</Link>
                    </li>
                    <li>
                        <Link to={"/services"}>Услуги</Link>
                    </li>
                    <li>
                        <Link to={"/about-us"}>За нас</Link>
                    </li>
                    <li>
                        <Link to={"/contact"}>Контакт</Link>
                    </li>
                    <li>
                    </li>
                </ul>
            </nav>
        </header>
    )

}

export default Header;