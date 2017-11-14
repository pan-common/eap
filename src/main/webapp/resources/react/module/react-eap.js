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
        //this.props.width=150;


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
                <select id="select" value={this.state.value} style={{width:this.props.width}}>
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

/**
 * 元素扩展属性录入控件
 */
class ElementExtend extends React.Component {

    constructor(props) {
        super(props);

        this.props.layuiForm; //layuiForm对象
        this.props.elementId;

        this.state = {
            layuiForm: this.props.layuiForm,
            elementExtends:[]//元素扩展属性

        };

    }

    onSelect(index){
        alert(index);
    }

    onChange(index,event){

    };

    componentDidMount() {
        this.serverRequest = $.get(baseServerUrl+"elementExtend/elementExtendList",{
            elementId:this.props.elementId
        },function (data,status) {
            if(status=="success"){
                if(data.body.resultCode=="0"){
                    this.setState({
                        elementExtends:data.body.entity
                    });
                    this.props.layuiForm.render();
                }else {
                    // parent.layer.msg(data.body.resultContent, {icon: 5});
                }
            }else {
                // parent.layer.msg('网络错误', {icon: 5});
            }
        }.bind(this));

        $("#addBtn").click(function () {
            var elementExtends = this.state.elementExtends;
            var elementExtend = new Object();
            elementExtend.elementId = this.props.elementId;
            elementExtend.extendField = "";
            elementExtend.extendName = "";
            elementExtend.extendType = "";
            elementExtend.note = "";
            elementExtends.push(elementExtend);
            this.setState({
                elementExtends:elementExtends
            });
            this.props.layuiForm.render();
        }.bind(this));
    }

    componentWillUpdate(nextProps, nextState) {

    }

    componentWillUnmount() {
        this.serverRequest.abort();
    }

    render() {

        var tbodys = [];
        this.state.elementExtends.map(
            (elementExtend,index)=>
             tbodys.push(<tr style={{height:30}} key={index}>
                <td><input style={{width:100}} type="text" value={elementExtend.extendField} className="layui-input" onChange={this.onChange.bind(this,index)}/></td>
                <td><input style={{width:100}} type="text" value={elementExtend.extendName} className="layui-input"/></td>
                <td><CommonSelect width={150} layuiForm={this.props.layuiForm} dataSource="dictionary" params="97" onSelect={this.onSelect.bind(this,index)}/></td>
                <td><input style={{width:100}} type="text" value={elementExtend.note} className="layui-input"/></td>
            </tr>)
        )

        return (
            <div>
                <table className="layui-table">
                    <thead>
                    <tr>
                        <td style={{textAlign:'center'}}>属性字段</td>
                        <td style={{textAlign:'center'}}>属性名</td>
                        <td style={{textAlign:'center'}}>字段类型</td>
                        <td style={{textAlign:'center'}}>备注</td>
                    </tr>
                    </thead>
                    <tbody>
                    {tbodys}
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colSpan="4" style={{textAlign:'center'}}>
                            <button id="addBtn" type="button" className="layui-btn layui-btn-small">
                                <i className="fa fa-plus"></i>&nbsp;&nbsp;新增
                            </button>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        );
    }
}