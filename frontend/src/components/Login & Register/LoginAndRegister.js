import React from "react";
import * as Components from './Components';

const LoginAndRegister = (props) => {
    const [signIn, toggle] = React.useState(true);
    return(
        <Components.Container>
            <Components.SignUpContainer signinIn={signIn}>
                <Components.Form>
                    <Components.Title>Креирај профил</Components.Title>
                    <Components.Input type='text' placeholder='Име' />
                    <Components.Input type='text' placeholder='Презиме' />
                    <Components.Input type='email' placeholder='E-пошта' />
                    <Components.Input type='text' placeholder='Корисничко име' />
                    <Components.Input type='password' placeholder='Лозинка' />
                    <Components.Input type='password' placeholder='Потврди лозинка' />
                    <Components.Button>РЕГИСТРИРАЈ СЕ</Components.Button>
                </Components.Form>
            </Components.SignUpContainer>

            <Components.SignInContainer signinIn={signIn}>
                <Components.Form>
                    <Components.Title>Најава</Components.Title>
                    <Components.Input type='email' placeholder='E-пошта' />
                    <Components.Input type='password' placeholder='Лозинка' />
                    <Components.Anchor href='#'>Заборавена лозинка?</Components.Anchor>
                    <Components.Button>НАЈАВИ СЕ</Components.Button>
                </Components.Form>
            </Components.SignInContainer>

            <Components.OverlayContainer signinIn={signIn}>
                <Components.Overlay signinIn={signIn}>

                    <Components.LeftOverlayPanel signinIn={signIn}>
                        <Components.Title>ДОБРЕДОЈДЕ НАЗАД!</Components.Title>
                        <Components.Paragraph>
                            Веќе си корисник? Најави се
                        </Components.Paragraph>
                        <Components.GhostButton onClick={() => toggle(true)}>
                            НАЈАВИ СЕ
                        </Components.GhostButton>
                    </Components.LeftOverlayPanel>

                    <Components.RightOverlayPanel signinIn={signIn}>
                        <Components.Title>Потребен ти е негувател?</Components.Title>
                        <Components.Paragraph>
                            Доколку се уште немаш креирано профил на Kindly, придружи ни се!
                        </Components.Paragraph>
                        <Components.GhostButton onClick={() => toggle(false)}>
                            РЕГИСТРИРАЈ СЕ
                        </Components.GhostButton>
                    </Components.RightOverlayPanel>

                </Components.Overlay>
            </Components.OverlayContainer>

        </Components.Container>
    )
}

export default LoginAndRegister;