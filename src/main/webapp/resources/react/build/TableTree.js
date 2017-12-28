"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var TableTree = function (_React$Component) {
    _inherits(TableTree, _React$Component);

    function TableTree(props) {
        _classCallCheck(this, TableTree);

        var _this = _possibleConstructorReturn(this, (TableTree.__proto__ || Object.getPrototypeOf(TableTree)).call(this, props));

        _this.props.url;
        _this.props.param;

        _this.state = {
            nodes: []
        };

        return _this;
    }

    _createClass(TableTree, [{
        key: "componentDidMount",
        value: function componentDidMount() {
            this.serverRequest = $.get(baseServerUrl + this.props.url, this.props.param, function (data) {
                this.setState({
                    nodes: data.body.entity
                });
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
                "table",
                { className: "layui-table" },
                this.state.nodes.map(function (item, index) {
                    return React.createElement(
                        "tr",
                        null,
                        React.createElement(
                            "td",
                            null,
                            item.name
                        )
                    );
                })
            );
        }
    }]);

    return TableTree;
}(React.Component);