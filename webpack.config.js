const path = require('path');

const CopyWebpackPlugin = require('copy-webpack-plugin');

var SRC_DIR = path.resolve(__dirname, 'src/main/ui');
var TARGET_DIR = path.resolve(__dirname, 'build/resources/main/static');

module.exports = {
    entry: SRC_DIR + '/index.js',
    output: {
        path: TARGET_DIR,
        filename: "index.js",
    },
    devtool: "source-map",
    module: {
        loaders: [
            {
                test: /\.js?/,
                loader: 'babel-loader',
                include: SRC_DIR,
                options: {
                    presets: ["env", "react"]
                }
            }
        ]
    },
    plugins: [
        new CopyWebpackPlugin([
            {context: SRC_DIR, from: './**/*.html', to: TARGET_DIR},
            {context: SRC_DIR, from: './**/*.css', to: TARGET_DIR},
        ])
    ]
};