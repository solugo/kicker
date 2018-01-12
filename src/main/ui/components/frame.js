import React from 'react';


export class Header extends React.Component {
    render() {
        return <div id="header">Header</div>;
    }
}

export class Footer extends React.Component {
    render() {
        return <div id="footer">Footer</div>;
    }
}

export class Menu extends React.Component {
    render() {
        return <div id="menu">Menu</div>;
    }
}

export class Content extends React.Component {
    render() {
        return <div id="content">Content</div>;
    }
}

export class Frame extends React.Component {
    render() {
        return [
            <Header/>,
            <Menu/>,
            <Content/>,
            <Footer/>
        ];
    }
}