var exec = require('cordova/exec');

var BMap = function() {};
BMap.bmap = function(map_param, success, error) {
    exec(success, error, "BMap", "bmap", [map_param]);
};

module.exports = BMap;