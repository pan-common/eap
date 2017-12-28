'use strict';

Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _propTypes = require('prop-types');

var _propTypes2 = _interopRequireDefault(_propTypes);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

TableEdit.PropTypes = {
    url: React.PropTypes.string.isRequired
};

var TableEdit = function (_React$Component) {
    _inherits(TableEdit, _React$Component);

    function TableEdit(props) {
        _classCallCheck(this, TableEdit);

        var _this = _possibleConstructorReturn(this, (TableEdit.__proto__ || Object.getPrototypeOf(TableEdit)).call(this, props));

        _this.state = {
            data: []
        };

        return _this;
    }

    _createClass(TableEdit, [{
        key: 'componentDidMount',
        value: function componentDidMount() {
            if (this.props.method.toLocaleUpperCase() == 'POST') {
                this.serverRequest = $.post(baseServerUrl + this.props.url, this.props.queryParams, function (data, status) {
                    if (status == "success") {
                        if (data.body.resultCode == '0') {
                            this.setState({
                                data: data.body.entity
                            });
                            this.props.layuiForm.render();
                        } else {}
                    } else {}
                }.bind(this));
            } else {
                this.serverRequest = $.get(baseServerUrl + this.props.url, this.props.queryParams, function (data, status) {
                    if (status == "success") {
                        if (data.body.resultCode == '0') {
                            this.setState({
                                data: data.body.entity
                            });
                            this.props.layuiForm.render();
                        } else {}
                    } else {}
                }.bind(this));
            }

            $("#addBtn").click(function () {
                var data = this.state.data;
                var item = new Object();
                data.push(item);
                this.setState({
                    data: data
                });
                this.props.layuiForm.render();
            }.bind(this));
        }
    }, {
        key: 'componentWillUpdate',
        value: function componentWillUpdate(nextProps, nextState) {}
    }, {
        key: 'componentWillUnmount',
        value: function componentWillUnmount() {
            this.serverRequest.abort();
        }
    }, {
        key: 'render',
        value: function render() {
            var _this2 = this;

            var tbodys = [];
            this.state.data.map(function (item, index) {
                return tbodys.push(React.createElement(
                    'tr',
                    { style: { height: '30px' }, key: index },
                    React.createElement(
                        'td',
                        { style: { textAlign: 'center', width: 80 } },
                        index + 1
                    ),
                    _this2.props.columns.map(function (colum, i) {
                        return React.createElement(
                            'td',
                            { style: { width: colum.width } },
                            React.createElement('input', { type: 'text', value: item[colum.field],
                                name: "datas[" + index + "]." + colum.field, className: 'layui-input',
                                onchange: function (index, event) {
                                    var temp = this.state.data;
                                    temp[index][colum.field] = event.target.value;
                                    this.setState({
                                        data: temp
                                    });
                                }.bind(_this2, index) })
                        );
                    }),
                    React.createElement(
                        'td',
                        { style: { textAlign: 'center', width: 100 } },
                        React.createElement(
                            'button',
                            { className: 'layui-btn layui-btn-small', type: 'button', onClick: function (index, event) {
                                    this.props.layuiLayer.confirm("确定执行删除操作？", {
                                        btn: ['确定', '取消']
                                    }, function () {
                                        var temp = this.state.data;
                                        temp.splice(index, 1);
                                        this.setState({
                                            data: temp
                                        });
                                        this.props.layuiForm.render();
                                        this.props.layuiLayer.close(this.props.layuiLayer.index);
                                    }.bind(this), function () {
                                        this.props.layuiLayer.close(this.props.layuiLayer.index);
                                    }.bind(this));
                                }.bind(_this2, index) },
                            '\u5220\u9664'
                        )
                    )
                ));
            });

            return React.createElement(
                'div',
                { style: { backgroundColor: "#F4F4F4" } },
                React.createElement(
                    'div',
                    { style: { paddingRight: 17 } },
                    React.createElement(
                        'table',
                        { className: 'layui-table' },
                        React.createElement(
                            'thead',
                            null,
                            React.createElement(
                                'tr',
                                null,
                                React.createElement(
                                    'th',
                                    { style: { textAlign: 'center', width: 80 } },
                                    '\u5E8F\u53F7'
                                ),
                                this.props.columns.map(function (colum, i) {
                                    return React.createElement(
                                        'th',
                                        { style: { textAlign: 'center', width: colum.width } },
                                        colum.title
                                    );
                                }),
                                React.createElement(
                                    'th',
                                    { style: { textAlign: 'center', width: 100 } },
                                    '\u64CD\u4F5C'
                                )
                            )
                        )
                    )
                ),
                React.createElement(
                    'div',
                    { style: { height: 400, overflow: 'auto' } },
                    React.createElement(
                        'table',
                        { className: 'layui-table' },
                        React.createElement(
                            'tbody',
                            null,
                            tbodys
                        )
                    )
                ),
                React.createElement(
                    'div',
                    { style: { paddingRight: 17, textAlign: "center" } },
                    React.createElement(
                        'button',
                        { style: { width: 200, marginTop: 10, marginBottom: 10 }, id: 'addBtn', type: 'button', className: 'layui-btn layui-btn-small' },
                        React.createElement('i', { className: 'fa fa-plus' }),
                        '\xA0\xA0\u65B0\u589E'
                    )
                )
            );
        }
    }]);

    return TableEdit;
}(React.Component);

exports.default = TableEdit;