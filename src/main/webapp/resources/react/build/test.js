"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var Test = function (_React$Component) {
    _inherits(Test, _React$Component);

    //构造方法
    function Test(props) {
        _classCallCheck(this, Test);

        var _this = _possibleConstructorReturn(this, (Test.__proto__ || Object.getPrototypeOf(Test)).call(this, props));

        _this.state = {
            date: new Date(),
            isToggleOn: true,
            content: "",
            numbers: [1, 2, 3, 4, 5, 6],
            value: "",
            textValue: "",
            selectValue: "a"
        };
        _this.onSubmit = _this.onSubmit.bind(_this);

        _this.handleChange = _this.handleChange.bind(_this);
        _this.handleSubmit = _this.handleSubmit.bind(_this);
        _this.textHandleChange = _this.textHandleChange.bind(_this);
        _this.selectChange = _this.selectChange.bind(_this);
        return _this;
    }

    _createClass(Test, [{
        key: "handleChange",
        value: function handleChange(event) {
            this.setState({ value: event.target.value });
        }
    }, {
        key: "handleSubmit",
        value: function handleSubmit(event) {
            event.preventDefault();
        }
    }, {
        key: "textHandleChange",
        value: function textHandleChange(event) {
            this.setState({ textValue: event.target.value });
        }
    }, {
        key: "selectChange",
        value: function selectChange(event) {
            this.setState({ selectValue: event.target.value });
        }

        //初始化组件时  挂载

    }, {
        key: "componentDidMount",
        value: function componentDidMount() {
            var _this2 = this;

            this.timerId = setInterval(function () {
                return _this2.tick();
            }, 1000);
        }
        //组件被移除时  卸载

    }, {
        key: "componentWillUnmount",
        value: function componentWillUnmount() {
            clearInterval(this.timerId);
        }
    }, {
        key: "tick",
        value: function tick() {
            this.setState({
                date: new Date()
            });
        }
    }, {
        key: "onSubmit",
        value: function onSubmit(content, e) {
            e.preventDefault();
            this.setState(function (prevState) {
                return {
                    isToggleOn: !prevState.isToggleOn
                };
            });
        }
    }, {
        key: "render",
        value: function render() {
            return React.createElement("div", null, React.createElement("h1", null, "Hello Word!"), React.createElement("h2", null, "\u6D4B\u8BD5", this.state.date.toLocaleString()), React.createElement("button", { className: "layui-btn", onClick: this.onSubmit.bind(this, "测试") }, this.state.isToggleOn ? "开" : "关", this.state.content), React.createElement("ul", null, this.state.numbers.map(function (number) {
                return React.createElement("li", null, number);
            })), React.createElement("form", { onSubmit: this.handleSubmit }, React.createElement("label", null, "name:", React.createElement("input", { type: "text", value: this.state.value, onChange: this.handleChange })), React.createElement("label", null, "\u6587\u672C\u5F55\u5165", React.createElement("textarea", { value: this.state.textValue, onChange: this.textHandleChange })), React.createElement("select", { value: this.state.selectValue, onChange: this.selectChange }, React.createElement("option", { value: "a" }, "\u94C5\u7B14"), React.createElement("option", { value: "b" }, "\u6A61\u76AE"), React.createElement("option", { value: "c" }, "\u6587\u5177\u76D2"), React.createElement("option", { value: "d" }, "\u4E66\u5305")), React.createElement("input", { type: "submit", value: "submit" })));
        }
    }]);

    return Test;
}(React.Component);

ReactDOM.render(React.createElement(Test, null), document.getElementById('root'));