import React from "react";
import {Link} from "react-router-dom";
import nav from "./styles.css";

const Header = () => {

    return(
        <header>
            <nav className="nav">
                <a href="/" className="SiteLogo">
                    <img src={`${process.env.PUBLIC_URL}/images/logo.jpg`} alt="Kindly Logo"
                         style={{width: "100px" }}/> {/* display the logo image with a smaller width */}
                </a>
                <ul>
                    <li>
                        <Link to={"#"}>Дома</Link>
                    </li>
                    <li>
                        <Link to={"#"}>Барај луѓе</Link>
                    </li>
                    <li>
                        <Link to={"#"}>Најави се</Link>
                    </li>
                    <li>
                        <Link to={"#"}>Регистрација</Link>
                    </li>
                    <li>
                        <Link to={"#"}>Одјави се</Link>
                    </li>
                </ul>
            </nav>
        </header>
    )

}

export default Header;