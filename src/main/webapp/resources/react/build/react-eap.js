"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

/**
 * 通用下拉框控件
 */
var CommonSelect = function (_React$Component) {
    _inherits(CommonSelect, _React$Component);

    function CommonSelect(props) {
        _classCallCheck(this, CommonSelect);

        // this.props.layuiForm="";//layuiForm对象
        // this.props.dataSource="";//数据源名称
        // this.props.params="";//参数
        // this.props.onSelect="";


        var _this = _possibleConstructorReturn(this, (CommonSelect.__proto__ || Object.getPrototypeOf(CommonSelect)).call(this, props));

        _this.state = {
            params: _this.props.params,
            value: "", //选中值
            datas: []
        };

        _this.refreshData = _this.refreshData.bind(_this);
        return _this;
    }

    _createClass(CommonSelect, [{
        key: "componentDidMount",
        value: function componentDidMount() {
            this.refreshData(this.props.params);
        }
    }, {
        key: "componentWillUpdate",
        value: function componentWillUpdate(nextProps, nextState) {
            $("#select").attr('lay-filter', 'commonSelect');
        }
    }, {
        key: "refreshData",
        value: function refreshData(params) {
            this.serverRequest = $.get(baseServerUrl + "common/getCommonSelectData", {
                datasource: this.props.dataSource,
                params: params
            }, function (data) {
                this.setState({
                    datas: data.body.entity
                });
                this.props.layuiForm.render();
                this.props.layuiForm.on("select(commonSelect)", function (data) {
                    this.props.onSelect(data.value);
                }.bind(this));
            }.bind(this));
        }
    }, {
        key: "componentWillUnmount",
        value: function componentWillUnmount() {
            this.serverRequest.abort();
        }
    }, {
        key: "render",
        value: function render() {
            return React.createElement(
                "div",
                null,
                React.createElement(
                    "select",
                    { id: "select", value: this.state.value },
                    React.createElement("option", { value: "" }),
                    this.state.datas.map(function (obj) {
                        return React.createElement(
                            "option",
                            { value: obj.key },
                            obj.value
                        );
                    })
                )
            );
        }
    }]);

    return CommonSelect;
}(React.Component);

/**
 * 数据库表的列表展示控件
 */


var TableList = function (_React$Component2) {
    _inherits(TableList, _React$Component2);

    function TableList(props) {
        _classCallCheck(this, TableList);

        var _this2 = _possibleConstructorReturn(this, (TableList.__proto__ || Object.getPrototypeOf(TableList)).call(this, props));

        _this2.state = {};

        return _this2;
    }

    _createClass(TableList, [{
        key: "componentDidMount",
        value: function componentDidMount() {}
    }, {
        key: "componentWillUpdate",
        value: function componentWillUpdate(nextProps, nextState) {}
    }, {
        key: "componentWillUnmount",
        value: function componentWillUnmount() {}
    }, {
        key: "render",
        value: function render() {
            return React.createElement("div", null);
        }
    }]);

    return TableList;
}(React.Component);