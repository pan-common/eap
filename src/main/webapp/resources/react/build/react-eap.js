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
        //this.props.width=150;


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
                    { id: "select", value: this.state.value, style: { width: this.props.width } },
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

/**
 * 元素扩展属性录入控件
 */


var ElementExtend = function (_React$Component3) {
    _inherits(ElementExtend, _React$Component3);

    function ElementExtend(props) {
        _classCallCheck(this, ElementExtend);

        var _this3 = _possibleConstructorReturn(this, (ElementExtend.__proto__ || Object.getPrototypeOf(ElementExtend)).call(this, props));

        _this3.props.layuiForm; //layuiForm对象
        _this3.props.elementId;

        _this3.state = {
            layuiForm: _this3.props.layuiForm,
            elementExtends: [] //元素扩展属性

        };

        return _this3;
    }

    _createClass(ElementExtend, [{
        key: "onSelect",
        value: function onSelect(index) {
            alert(index);
        }
    }, {
        key: "onChange",
        value: function onChange(index, event) {
            alert(event.target.value);
        }
    }, {
        key: "componentDidMount",
        value: function componentDidMount() {
            this.serverRequest = $.get(baseServerUrl + "elementExtend/elementExtendList", {
                elementId: this.props.elementId
            }, function (data, status) {
                if (status == "success") {
                    if (data.body.resultCode == "0") {
                        this.setState({
                            elementExtends: data.body.entity
                        });
                        this.props.layuiForm.render();
                    } else {
                        // parent.layer.msg(data.body.resultContent, {icon: 5});
                    }
                } else {
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
                    elementExtends: elementExtends
                });
                this.props.layuiForm.render();
            }.bind(this));
        }
    }, {
        key: "componentWillUpdate",
        value: function componentWillUpdate(nextProps, nextState) {}
    }, {
        key: "componentWillUnmount",
        value: function componentWillUnmount() {
            this.serverRequest.abort();
        }
    }, {
        key: "render",
        value: function render() {
            var _this4 = this;

            var tbodys = [];
            this.state.elementExtends.map(function (elementExtend, index) {
                return tbodys.push(React.createElement(
                    "tr",
                    { style: { height: 30 }, key: index },
                    React.createElement(
                        "td",
                        null,
                        React.createElement("input", { style: { width: 100 }, type: "text", value: elementExtend.extendField, className: "layui-input", onChange: _this4.onChange.bind(_this4, index) })
                    ),
                    React.createElement(
                        "td",
                        null,
                        React.createElement("input", { style: { width: 100 }, type: "text", value: elementExtend.extendName, className: "layui-input" })
                    ),
                    React.createElement(
                        "td",
                        null,
                        React.createElement(CommonSelect, { width: 150, layuiForm: _this4.props.layuiForm, dataSource: "dictionary", params: "97", onSelect: _this4.onSelect.bind(_this4, index) })
                    ),
                    React.createElement(
                        "td",
                        null,
                        React.createElement("input", { style: { width: 100 }, type: "text", value: elementExtend.note, className: "layui-input" })
                    )
                ));
            });

            return React.createElement(
                "div",
                null,
                React.createElement(
                    "table",
                    { className: "layui-table" },
                    React.createElement(
                        "thead",
                        null,
                        React.createElement(
                            "tr",
                            null,
                            React.createElement(
                                "td",
                                { style: { textAlign: 'center' } },
                                "\u5C5E\u6027\u5B57\u6BB5"
                            ),
                            React.createElement(
                                "td",
                                { style: { textAlign: 'center' } },
                                "\u5C5E\u6027\u540D"
                            ),
                            React.createElement(
                                "td",
                                { style: { textAlign: 'center' } },
                                "\u5B57\u6BB5\u7C7B\u578B"
                            ),
                            React.createElement(
                                "td",
                                { style: { textAlign: 'center' } },
                                "\u5907\u6CE8"
                            )
                        )
                    ),
                    React.createElement(
                        "tbody",
                        null,
                        tbodys
                    ),
                    React.createElement(
                        "tfoot",
                        null,
                        React.createElement(
                            "tr",
                            null,
                            React.createElement(
                                "td",
                                { colSpan: "4", style: { textAlign: 'center' } },
                                React.createElement(
                                    "button",
                                    { id: "addBtn", type: "button", className: "layui-btn layui-btn-small" },
                                    React.createElement("i", { className: "fa fa-plus" }),
                                    "\xA0\xA0\u65B0\u589E"
                                )
                            )
                        )
                    )
                )
            );
        }
    }]);

    return ElementExtend;
}(React.Component);