class TableTree extends React.Component{

    constructor(props){
        super(props);

        this.props.url;
        this.props.param;

        this.state = {
            nodes:[]
        }

    }

    componentDidMount(){
        this.serverRequest = $.get(baseServerUrl+this.props.url,
            this.props.param,
            function (data) {
            this.setState({
                nodes:data.body.entity
            });
            }.bind(this));
    }

    componentWillUnmount() {
        this.serverRequest.abort();
    }

    render(){
        return(
            <table className="layui-table">
                {
                    this.state.nodes.map((item,index)=>
                    <tr><td>{item.name}</td></tr>
                    )
                }
            </table>
        );
    }

}