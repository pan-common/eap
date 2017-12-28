var path = require('path');

var ROOT_PATH = path.resolve(__dirname);
var APP_PATH = path.resolve(ROOT_PATH,'app');
var BUILD_PATH = path.resolve(ROOT_PATH,'build');

module.exports = {
    entry:APP_PATH,
    output: {
        path: BUILD_PATH,
        filename: 'eap-react.js',
        libraryTarget: "umd"
    },
    externals: {
        "react": 'react',
        "jquery": 'jQuery',
        'react-dom': 'ReactDOM'
    },
    devtool:'eval-source-map',
    module:{
        loaders:[
            {
                test: /\.js$/, // babel 转换为兼容性的 js
                exclude: /node_modules/,
                loader: 'babel-loader',
                query: {
                    presets: ["es2015", "react"]
                }
            }
        ]
    }

};