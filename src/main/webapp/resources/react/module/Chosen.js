class Chosen extends React.Component{

    componentDidMount(){

    }

    componentDidUpdate(){

    }

    componentWillUnmount(){

    }

    handleChange(){

    }

    render(){
        return(
            <div>
                <select className="Chosen-select" ref={el=>this.el=el}>

                </select>
            </div>
        );
    }
}

function Example() {
    return (
        <Chosen onChange={value => console.log(value)}>
            <option>vanilla</option>
            <option>chocolate</option>
            <option>strawberry</option>
        </Chosen>
    );
}

ReactDOM.render(
    <Example />,
    document.getElementById('root')
);