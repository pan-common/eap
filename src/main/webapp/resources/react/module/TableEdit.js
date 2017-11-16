class TableEdit extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            data:[]
        };

    }

    componentDidMount(){
        if(this.props.method.toLocaleUpperCase()=='POST'){
            this.serverRequest = $.post(baseServerUrl+this.props.url,
                this.props.queryParams,
                function (data,status) {
                    if(status=="success"){
                        if(data.body.resultCode=='0'){
                            this.setState({
                                data:data.body.entity
                            });
                            this.props.layuiForm.render();
                        }else {

                        }
                    }else {

                    }
                }.bind(this));
        }else {
            this.serverRequest = $.get(baseServerUrl+this.props.url,
                this.props.queryParams,
                function (data,status) {
                    if(status=="success"){
                        if(data.body.resultCode=='0'){
                            this.setState({
                                data:data.body.entity
                            });
                            this.props.layuiForm.render();
                        }else {

                        }
                    }else {

                    }
                }.bind(this));
        }

        $("#addBtn").click(function () {
            var data = this.state.data;
            var item = new Object();
            data.push(item);
            this.setState({
                data:data
            });
            this.props.layuiForm.render();
        }.bind(this));

    }

    componentWillUpdate(nextProps, nextState) {

    }

    componentWillUnmount() {
        this.serverRequest.abort();
    }

    render(){
        var tbodys = [];
        this.state.data.map(
            (item,index)=>
                tbodys.push(
                    <tr style={{height:30}} key={index}>
                        <td style={{textAlign:'center',width:80}}>{index+1}</td>
                        {
                            this.props.columns.map(
                                (colum,i)=>
                                    <td style={{width:colum.width}}>
                                        <input type='text' value={item[colum.field]}
                                               name={"datas["+index+"]."+colum.field} className="layui-input"
                                               onchange={function (index,event) {
                                                   var temp = this.state.data;
                                                   temp[index][colum.field] = event.target.value;
                                                   this.setState({
                                                       data:temp
                                                   });
                                               }.bind(this,index)}/>
                                    </td>
                            )
                        }
                        <td style={{textAlign:'center',width:100}}><button className="layui-btn layui-btn-small" type="button" onClick={function (index,event) {
                            this.props.layuiLayer.confirm("确定执行删除操作？",{
                                btn:['确定','取消']
                            },function () {
                                var temp = this.state.data;
                                temp.splice(index,1);
                                this.setState({
                                    data:temp
                                });
                                this.props.layuiForm.render();
                                this.props.layuiLayer.close(this.props.layuiLayer.index);
                            }.bind(this),function () {
                                this.props.layuiLayer.close(this.props.layuiLayer.index);
                            }.bind(this));
                        }.bind(this,index)}>删除</button></td>
                    </tr>
                )
        );

        return(
            <div style={{backgroundColor:"#F4F4F4"}}>
                <div style={{paddingRight:17}}>
                    <table className="layui-table">
                        <thead>
                        <tr>
                            <th style={{textAlign:'center',width:80}}>序号</th>
                            {
                                this.props.columns.map(
                                    (colum,i)=>
                                        <th style={{textAlign:'center',width:colum.width}}>{colum.title}</th>
                                )
                            }
                            <th style={{textAlign:'center',width:100}}>操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <div style={{height:400,overflow:'auto'}}>
                    <table className="layui-table">
                        <tbody>
                        {tbodys}
                        </tbody>
                    </table>
                </div>
                <div style={{paddingRight:17,textAlign:"center"}}>
                    <button style={{width:200,marginTop:10,marginBottom:10}} id="addBtn" type="button" className="layui-btn layui-btn-small">
                        <i className="fa fa-plus"></i>&nbsp;&nbsp;新增
                    </button>
                </div>
            </div>
        );

    }
}