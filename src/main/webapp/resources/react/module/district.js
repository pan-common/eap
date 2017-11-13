//区划
class District extends React.Component {

    constructor(props) {
        super(props);

        this.props.layuiForm; //layuiForm对象
        this.props.province; //初始省
        this.props.city; //初始市
        this.props.district; //初始县
        this.props.url; //获取区划的url
        this.props.onSelect; //选择之后触发的回调函数
        this.props.name; //input的name名称
        this.props.title; //标题

        this.state = {
            layuiForm: this.props.layuiForm,
            areas: [], //省区划数据存放变量
            citys: [], //市区划数据存放变量
            districts: [], //县区区划数据存放变量
            province: this.props.province, //当前选中省
            city: this.props.city, //当前选中市
            district: this.props.district //当前选中县
        };

        this.setResult = this.setResult.bind(this);
    }

    componentDidMount() {
        this.serverRequest = $.get(baseServerUrl + this.props.url, {
            parentId: 1
        }, function (data) {
            this.setState({
                areas: data.body.entity,
                citys: data.body.entity[0].children,
                districts: data.body.entity[0].children[0].children,
                province: this.props.province,
                city: this.props.city,
                district: this.props.district
            });
            this.props.layuiForm.render();
            this.props.layuiForm.on('select(province)', function (data) {
                var province = data.value;
                if (province && province != "") {
                    for (let i = 0; i < this.state.areas.length; i++) {
                        if (province == this.state.areas[i].areaId) {
                            this.setState({
                                province: province,
                                citys: this.state.areas[i].children,
                                city: this.state.areas[i].children[0].areaId,
                                districts: this.state.areas[i].children[0].children,
                                district: this.state.areas[i].children[0].children[0].areaId
                            });
                            this.props.layuiForm.render();
                        }
                    }
                } else {
                    this.setState({
                        province: province,
                        citys: [], //市区划数据存放变量
                        districts: [], //县区区划数据存放变量
                        city: "", //当前选中市
                        district: "" //当前选中县
                    });
                    this.props.layuiForm.render();
                }
                this.setResult();
            }.bind(this));
            this.props.layuiForm.on('select(city)', function (data) {
                var city = data.value;
                if (city && city != "") {
                    for (let i = 0; i < this.state.citys.length; i++) {
                        if (city == this.state.citys[i].areaId) {
                            this.setState({
                                city: city,
                                districts: this.state.citys[i].children,
                                district: this.state.citys[i].children[0].areaId
                            });
                            this.props.layuiForm.render();
                        }
                    }
                } else {
                    this.setState({
                        districts: [], //县区区划数据存放变量
                        city: city, //当前选中市
                        district: "" //当前选中县
                    });
                    this.props.layuiForm.render();
                }
                this.setResult();
            }.bind(this));
            this.props.layuiForm.on('select(district)', function (data) {
                var district = data.value;
                this.setState({
                    district: district
                });
                this.props.layuiForm.render();
                this.setResult();
            }.bind(this));
        }.bind(this));
    }

    setResult() {
        if (this.state.district && this.state.district != '') {
            $("#result").val(this.state.district);
        } else if (this.state.city && this.state.city != '') {
            $("#result").val(this.state.city);
        } else if (this.state.province && this.state.province != '') {
            $("#result").val(this.state.province);
        } else {
            $("#result").val("");
        }
        this.props.onSelect($("#result").val());
    }

    componentWillUpdate(nextProps, nextState) {
        $("#province").attr('lay-filter', 'province');
        $("#province").attr('lay-search', '');
        $("#city").attr('lay-filter', 'city');
        $("#city").attr('lay-search', '');
        $("#county").attr('lay-filter', 'district');
        $("#county").attr('lay-search', '');
    }

    componentWillUnmount() {
        this.serverRequest.abort();
    }

    render() {
        return React.createElement("div", { className: "layui-form-item" }, React.createElement("input", { id: "result", type: "hidden", name: this.props.name }), React.createElement("label", { className: "layui-form-label" }, React.createElement("span", null, "*"), this.props.title), React.createElement("div", { className: "layui-input-inline" }, React.createElement("select", { id: "province", className: "select-title", value: this.state.province }, React.createElement("option", { value: "" }), this.state.areas.map(area => React.createElement("option", { value: area.areaId }, area.name)))), React.createElement("div", { className: "layui-input-inline" }, React.createElement("select", { id: "city", className: "select-title",
            value: this.state.city }, React.createElement("option", { value: "" }), this.state.citys.map(city => React.createElement("option", { value: city.areaId }, city.name)))), React.createElement("div", { className: "layui-input-inline" }, React.createElement("select", { id: "county", className: "select-title", value: this.state.district }, React.createElement("option", { value: "" }), this.state.districts.map(district => React.createElement("option", { value: district.areaId }, district.name)))));
    }

}