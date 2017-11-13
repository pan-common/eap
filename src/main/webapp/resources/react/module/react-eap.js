/**
 * 通用下拉框控件
 */
class CommonSelect extends React.Component{

    constructor(props){
        super(props);
        // this.props.layuiForm="";//layuiForm对象
        // this.props.dataSource="";//数据源名称
        // this.props.params="";//参数
        // this.props.onSelect="";


        this.state = {
            params:this.props.params,
            value:"",//选中值
            datas:[]
        };

        this.refreshData = this.refreshData.bind(this);
    }
    componentDidMount(){
        this.refreshData(this.props.params);
    }

    componentWillUpdate(nextProps, nextState){
        $("#select").attr('lay-filter','commonSelect');
    }

    refreshData(params){
        this.serverRequest = $.get(baseServerUrl+"common/getCommonSelectData",
            {
                datasource:this.props.dataSource,
                params:params
            },
            function (data) {
                this.setState({
                    datas:data.body.entity
                });
                this.props.layuiForm.render();
                this.props.layuiForm.on("select(commonSelect)",function (data) {
                    this.props.onSelect(data.value);
                }.bind(this));
            }.bind(this));
    }

    componentWillUnmount() {
        this.serverRequest.abort();
    }

    render(){
        return(
            <div>
                <select id="select" value={this.state.value}>
                    <option value=""></option>
                    {this.state.datas.map(
                            (obj)=><option value={obj.key}>{obj.value}</option>
                        )}
                </select>
            </div>
        );
    }

}


/**
 * 数据库表的列表展示控件
 */
class TableList extends React.Component{

    constructor(props){
        super(props);

        this.state = {

        };

    }

    componentDidMount(){

    }

    componentWillUpdate(nextProps, nextState){

    }

    componentWillUnmount() {

    }

    render(){
        return(
            <div>

            </div>
        );
    }

}