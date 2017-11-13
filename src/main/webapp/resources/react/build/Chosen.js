"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var Chosen = function (_React$Component) {
    _inherits(Chosen, _React$Component);

    function Chosen() {
        _classCallCheck(this, Chosen);

        return _possibleConstructorReturn(this, (Chosen.__proto__ || Object.getPrototypeOf(Chosen)).apply(this, arguments));
    }

    _createClass(Chosen, [{
        key: "componentDidMount",
        value: function componentDidMount() {}
    }, {
        key: "componentDidUpdate",
        value: function componentDidUpdate() {}
    }, {
        key: "componentWillUnmount",
        value: function componentWillUnmount() {}
    }, {
        key: "handleChange",
        value: function handleChange() {}
    }, {
        key: "render",
        value: function render() {
            var _this2 = this;

            return React.createElement(
                "div",
                null,
                React.createElement("select", { className: "Chosen-select", ref: function ref(el) {
                        return _this2.el = el;
                    } })
            );
        }
    }]);

    return Chosen;
}(React.Component);

function Example() {
    return React.createElement(
        Chosen,
        { onChange: function onChange(value) {
                return console.log(value);
            } },
        React.createElement(
            "option",
            null,
            "vanilla"
        ),
        React.createElement(
            "option",
            null,
            "chocolate"
        ),
        React.createElement(
            "option",
            null,
            "strawberry"
        )
    );
}

ReactDOM.render(React.createElement(Example, null), document.getElementById('root'));