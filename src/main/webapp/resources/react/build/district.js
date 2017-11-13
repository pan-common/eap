"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

//区划
var District = function (_React$Component) {
    _inherits(District, _React$Component);

    function District(props) {
        _classCallCheck(this, District);

        var _this = _possibleConstructorReturn(this, (District.__proto__ || Object.getPrototypeOf(District)).call(this, props));

        _this.props.layuiForm; //layuiForm对象
        _this.props.province; //初始省
        _this.props.city; //初始市
        _this.props.district; //初始县
        _this.props.url; //获取区划的url
        _this.props.onSelect; //选择之后触发的回调函数
        _this.props.name; //input的name名称
        _this.props.title; //标题

        _this.state = {
            layuiForm: _this.props.layuiForm,
            areas: [], //省区划数据存放变量
            citys: [], //市区划数据存放变量
            districts: [], //县区区划数据存放变量
            province: _this.props.province, //当前选中省
            city: _this.props.city, //当前选中市
            district: _this.props.district //当前选中县
        };

        _this.setResult = _this.setResult.bind(_this);
        return _this;
    }

    _createClass(District, [{
        key: "componentDidMount",
        value: function componentDidMount() {
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
                        for (var i = 0; i < this.state.areas.length; i++) {
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
                        for (var i = 0; i < this.state.citys.length; i++) {
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
    }, {
        key: "setResult",
        value: function setResult() {
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
    }, {
        key: "componentWillUpdate",
        value: function componentWillUpdate(nextProps, nextState) {
            $("#province").attr('lay-filter', 'province');
            $("#province").attr('lay-search', '');
            $("#city").attr('lay-filter', 'city');
            $("#city").attr('lay-search', '');
            $("#county").attr('lay-filter', 'district');
            $("#county").attr('lay-search', '');
        }
    }, {
        key: "componentWillUnmount",
        value: function componentWillUnmount() {
            this.serverRequest.abort();
        }
    }, {
        key: "render",
        value: function render() {
            return React.createElement("div", { className: "layui-form-item" }, React.createElement("input", { id: "result", type: "hidden", name: this.props.name }), React.createElement("label", { className: "layui-form-label" }, React.createElement("span", null, "*"), this.props.title), React.createElement("div", { className: "layui-input-inline" }, React.createElement("select", { id: "province", className: "select-title", value: this.state.province }, React.createElement("option", { value: "" }), this.state.areas.map(function (area) {
                return React.createElement("option", { value: area.areaId }, area.name);
            }))), React.createElement("div", { className: "layui-input-inline" }, React.createElement("select", { id: "city", className: "select-title",
                value: this.state.city }, React.createElement("option", { value: "" }), this.state.citys.map(function (city) {
                return React.createElement("option", { value: city.areaId }, city.name);
            }))), React.createElement("div", { className: "layui-input-inline" }, React.createElement("select", { id: "county", className: "select-title", value: this.state.district }, React.createElement("option", { value: "" }), this.state.districts.map(function (district) {
                return React.createElement("option", { value: district.areaId }, district.name);
            }))));
        }
    }]);

    return District;
}(React.Component);