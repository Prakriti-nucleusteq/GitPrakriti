import React from "react";
import { Card, CardBody } from "reactstrap";

function Header({ name, title}){
    return (
        <div>
            <Card className="my-4 bg-warning">
                <CardBody>
                  <h1 className="text-center">Welcome to Helpdesk Portal</h1>
                </CardBody>
            </Card>
            
        </div>
    )
}

export default Header;