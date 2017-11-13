class Test extends React.Component {

    //构造方法
    constructor(props) {
        super(props);

        this.state = {
            date: new Date(),
            isToggleOn: true,
            content: "",
            numbers: [1, 2, 3, 4, 5, 6],
            value: "",
            textValue: "",
            selectValue: "a"
        };
        this.onSubmit = this.onSubmit.bind(this);

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.textHandleChange = this.textHandleChange.bind(this);
        this.selectChange = this.selectChange.bind(this);
    }

    handleChange(event) {
        this.setState({ value: event.target.value });
    }

    handleSubmit(event) {
        event.preventDefault();
    }

    textHandleChange(event) {
        this.setState({ textValue: event.target.value });
    }

    selectChange(event) {
        this.setState({ selectValue: event.target.value });
    }

    //初始化组件时  挂载
    componentDidMount() {
        this.timerId = setInterval(() => this.tick(), 1000);
    }
    //组件被移除时  卸载
    componentWillUnmount() {
        clearInterval(this.timerId);
    }

    tick() {
        this.setState({
            date: new Date()
        });
    }

    onSubmit(content, e) {
        e.preventDefault();
        this.setState(prevState => ({
            isToggleOn: !prevState.isToggleOn
        }));
    }

    render() {
        return React.createElement("div", null, React.createElement("h1", null, "Hello Word!"), React.createElement("h2", null, "\u6D4B\u8BD5", this.state.date.toLocaleString()), React.createElement("button", { className: "layui-btn", onClick: this.onSubmit.bind(this, "测试") }, this.state.isToggleOn ? "开" : "关", this.state.content), React.createElement("ul", null, this.state.numbers.map(number => React.createElement("li", null, number))), React.createElement("form", { onSubmit: this.handleSubmit }, React.createElement("label", null, "name:", React.createElement("input", { type: "text", value: this.state.value, onChange: this.handleChange })), React.createElement("label", null, "\u6587\u672C\u5F55\u5165", React.createElement("textarea", { value: this.state.textValue, onChange: this.textHandleChange })), React.createElement("select", { value: this.state.selectValue, onChange: this.selectChange }, React.createElement("option", { value: "a" }, "\u94C5\u7B14"), React.createElement("option", { value: "b" }, "\u6A61\u76AE"), React.createElement("option", { value: "c" }, "\u6587\u5177\u76D2"), React.createElement("option", { value: "d" }, "\u4E66\u5305")), React.createElement("input", { type: "submit", value: "submit" })));
    }

}

ReactDOM.render(React.createElement(Test, null), document.getElementById('root'));