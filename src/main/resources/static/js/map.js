function drawMap() {
    var geoCoordMap = {
        "海门": [121.15, 31.89],
        "鄂尔多斯": [109.781327, 39.608266],
        "招远": [120.38, 37.35],
        "舟山": [122.207216, 29.985295],
        "齐齐哈尔": [123.97, 47.33],
        "盐城": [120.13, 33.38],
        "赤峰": [118.87, 42.28],
        "青岛": [120.33, 36.07],
        "乳山": [121.52, 36.89],
        "金昌": [102.188043, 38.520089],
        "泉州": [118.58, 24.93],
        "莱西": [120.53, 36.86],
        "日照": [119.46, 35.42],
        "胶南": [119.97, 35.88],
        "南通": [121.05, 32.08],
        "拉萨": [91.11, 29.97],
        "云浮": [112.02, 22.93],
        "梅州": [116.1, 24.55],
        "文登": [122.05, 37.2],
        "上海": [121.48, 31.22],
        "攀枝花": [101.718637, 26.582347],
        "威海": [122.1, 37.5],
        "承德": [117.93, 40.97],
        "厦门": [118.1, 24.46],
        "汕尾": [115.375279, 22.786211],
        "潮州": [116.63, 23.68],
        "丹东": [124.37, 40.13],
        "太仓": [121.1, 31.45],
        "曲靖": [103.79, 25.51],
        "烟台": [121.39, 37.52],
        "福州": [119.3, 26.08],
        "瓦房店": [121.979603, 39.627114],
        "即墨": [120.45, 36.38],
        "抚顺": [123.97, 41.97],
        "玉溪": [102.52, 24.35],
        "张家口": [114.87, 40.82],
        "阳泉": [113.57, 37.85],
        "莱州": [119.942327, 37.177017],
        "湖州": [120.1, 30.86],
        "汕头": [116.69, 23.39],
        "昆山": [120.95, 31.39],
        "宁波": [121.56, 29.86],
        "湛江": [110.359377, 21.270708],
        "揭阳": [116.35, 23.55],
        "荣成": [122.41, 37.16],
        "连云港": [119.16, 34.59],
        "葫芦岛": [120.836932, 40.711052],
        "常熟": [120.74, 31.64],
        "东莞": [113.75, 23.04],
        "河源": [114.68, 23.73],
        "淮安": [119.15, 33.5],
        "泰州": [119.9, 32.49],
        "南宁": [108.33, 22.84],
        "营口": [122.18, 40.65],
        "惠州": [114.4, 23.09],
        "江阴": [120.26, 31.91],
        "蓬莱": [120.75, 37.8],
        "韶关": [113.62, 24.84],
        "嘉峪关": [98.289152, 39.77313],
        "广州": [113.23, 23.16],
        "延安": [109.47, 36.6],
        "太原": [112.53, 37.87],
        "清远": [113.01, 23.7],
        "中山": [113.38, 22.52],
        "昆明": [102.73, 25.04],
        "寿光": [118.73, 36.86],
        "盘锦": [122.070714, 41.119997],
        "长治": [113.08, 36.18],
        "深圳": [114.07, 22.62],
        "珠海": [113.52, 22.3],
        "宿迁": [118.3, 33.96],
        "咸阳": [108.72, 34.36],
        "铜川": [109.11, 35.09],
        "平度": [119.97, 36.77],
        "佛山": [113.11, 23.05],
        "海口": [110.35, 20.02],
        "江门": [113.06, 22.61],
        "章丘": [117.53, 36.72],
        "肇庆": [112.44, 23.05],
        "大连": [121.62, 38.92],
        "临汾": [111.5, 36.08],
        "吴江": [120.63, 31.16],
        "石嘴山": [106.39, 39.04],
        "沈阳": [123.38, 41.8],
        "苏州": [120.62, 31.32],
        "茂名": [110.88, 21.68],
        "嘉兴": [120.76, 30.77],
        "长春": [125.35, 43.88],
        "胶州": [120.03336, 36.264622],
        "银川": [106.27, 38.47],
        "张家港": [120.555821, 31.875428],
        "三门峡": [111.19, 34.76],
        "锦州": [121.15, 41.13],
        "南昌": [115.89, 28.68],
        "柳州": [109.4, 24.33],
        "三亚": [109.511909, 18.252847],
        "自贡": [104.778442, 29.33903],
        "吉林": [126.57, 43.87],
        "阳江": [111.95, 21.85],
        "泸州": [105.39, 28.91],
        "西宁": [101.74, 36.56],
        "宜宾": [104.56, 29.77],
        "呼和浩特": [111.65, 40.82],
        "成都": [104.06, 30.67],
        "大同": [113.3, 40.12],
        "镇江": [119.44, 32.2],
        "桂林": [110.28, 25.29],
        "张家界": [110.479191, 29.117096],
        "宜兴": [119.82, 31.36],
        "北海": [109.12, 21.49],
        "西安": [108.95, 34.27],
        "金坛": [119.56, 31.74],
        "东营": [118.49, 37.46],
        "牡丹江": [129.58, 44.6],
        "遵义": [106.9, 27.7],
        "绍兴": [120.58, 30.01],
        "扬州": [119.42, 32.39],
        "常州": [119.95, 31.79],
        "潍坊": [119.1, 36.62],
        "重庆": [106.54, 29.59],
        "台州": [121.420757, 28.656386],
        "南京": [118.78, 32.04],
        "滨州": [118.03, 37.36],
        "贵阳": [106.71, 26.57],
        "无锡": [120.29, 31.59],
        "本溪": [123.73, 41.3],
        "克拉玛依": [84.77, 45.59],
        "渭南": [109.5, 34.52],
        "马鞍山": [118.48, 31.56],
        "宝鸡": [107.15, 34.38],
        "焦作": [113.21, 35.24],
        "句容": [119.16, 31.95],
        "北京": [116.46, 39.92],
        "徐州": [117.2, 34.26],
        "衡水": [115.72, 37.72],
        "包头": [110, 40.58],
        "绵阳": [104.73, 31.48],
        "乌鲁木齐": [87.68, 43.77],
        "枣庄": [117.57, 34.86],
        "杭州": [120.19, 30.26],
        "淄博": [118.05, 36.78],
        "鞍山": [122.85, 41.12],
        "溧阳": [119.48, 31.43],
        "库尔勒": [86.06, 41.68],
        "安阳": [114.35, 36.1],
        "开封": [114.35, 34.79],
        "济南": [117, 36.65],
        "德阳": [104.37, 31.13],
        "温州": [120.65, 28.01],
        "九江": [115.97, 29.71],
        "邯郸": [114.47, 36.6],
        "临安": [119.72, 30.23],
        "兰州": [103.73, 36.03],
        "沧州": [116.83, 38.33],
        "临沂": [118.35, 35.05],
        "南充": [106.110698, 30.837793],
        "天津": [117.2, 39.13],
        "富阳": [119.95, 30.07],
        "泰安": [117.13, 36.18],
        "诸暨": [120.23, 29.71],
        "郑州": [113.65, 34.76],
        "哈尔滨": [126.63, 45.75],
        "聊城": [115.97, 36.45],
        "芜湖": [118.38, 31.33],
        "唐山": [118.02, 39.63],
        "平顶山": [113.29, 33.75],
        "邢台": [114.48, 37.05],
        "德州": [116.29, 37.45],
        "济宁": [116.59, 35.38],
        "荆州": [112.239741, 30.335165],
        "宜昌": [111.3, 30.7],
        "义乌": [120.06, 29.32],
        "丽水": [119.92, 28.45],
        "洛阳": [112.44, 34.7],
        "秦皇岛": [119.57, 39.95],
        "株洲": [113.16, 27.83],
        "石家庄": [114.48, 38.03],
        "莱芜": [117.67, 36.19],
        "常德": [111.69, 29.05],
        "保定": [115.48, 38.85],
        "湘潭": [112.91, 27.87],
        "金华": [119.64, 29.12],
        "岳阳": [113.09, 29.37],
        "长沙": [113, 28.21],
        "衢州": [118.88, 28.97],
        "廊坊": [116.7, 39.53],
        "菏泽": [115.480656, 35.23375],
        "合肥": [117.27, 31.86],
        "武汉": [114.31, 30.52],
        "大庆": [125.03, 46.58]
    };
    var data = [
        {name: '海门', value: 9},
        {name: '鄂尔多斯', value: 12},
        {name: '招远', value: 12},
        {name: '舟山', value: 12},
        {name: '齐齐哈尔', value: 14},
        {name: '盐城', value: 15},
        {name: '赤峰', value: 16},
        {name: '青岛', value: 18},
        {name: '乳山', value: 18},
        {name: '金昌', value: 19},
        {name: '泉州', value: 21},
        {name: '莱西', value: 21},
        {name: '日照', value: 21},
        {name: '胶南', value: 22},
        {name: '南通', value: 23},
        {name: '拉萨', value: 24},
        {name: '云浮', value: 24},
        {name: '梅州', value: 25},
        {name: '文登', value: 25},
        {name: '上海', value: 25},
        {name: '攀枝花', value: 25},
        {name: '威海', value: 25},
        {name: '承德', value: 25},
        {name: '厦门', value: 26},
        {name: '汕尾', value: 26},
        {name: '潮州', value: 26},
        {name: '丹东', value: 27},
        {name: '太仓', value: 27},
        {name: '曲靖', value: 27},
        {name: '烟台', value: 28},
        {name: '福州', value: 29},
        {name: '瓦房店', value: 30},
        {name: '即墨', value: 30},
        {name: '抚顺', value: 31},
        {name: '玉溪', value: 31},
        {name: '张家口', value: 31},
        {name: '阳泉', value: 31},
        {name: '莱州', value: 32},
        {name: '湖州', value: 32},
        {name: '汕头', value: 32},
        {name: '昆山', value: 33},
        {name: '宁波', value: 33},
        {name: '湛江', value: 33},
        {name: '揭阳', value: 34},
        {name: '荣成', value: 34},
        {name: '连云港', value: 35},
        {name: '葫芦岛', value: 35},
        {name: '常熟', value: 36},
        {name: '东莞', value: 36},
        {name: '河源', value: 36},
        {name: '淮安', value: 36},
        {name: '泰州', value: 36},
        {name: '南宁', value: 37},
        {name: '营口', value: 37},
        {name: '惠州', value: 37},
        {name: '江阴', value: 37},
        {name: '蓬莱', value: 37},
        {name: '韶关', value: 38},
        {name: '嘉峪关', value: 38},
        {name: '广州', value: 38},
        {name: '延安', value: 38},
        {name: '太原', value: 39},
        {name: '清远', value: 39},
        {name: '中山', value: 39},
        {name: '昆明', value: 39},
        {name: '寿光', value: 40},
        {name: '盘锦', value: 40},
        {name: '长治', value: 41},
        {name: '深圳', value: 41},
        {name: '珠海', value: 42},
        {name: '宿迁', value: 43},
        {name: '咸阳', value: 43},
        {name: '铜川', value: 44},
        {name: '平度', value: 44},
        {name: '佛山', value: 44},
        {name: '海口', value: 44},
        {name: '江门', value: 45},
        {name: '章丘', value: 45},
        {name: '肇庆', value: 46},
        {name: '大连', value: 47},
        {name: '临汾', value: 47},
        {name: '吴江', value: 47},
        {name: '石嘴山', value: 49},
        {name: '沈阳', value: 50},
        {name: '苏州', value: 50},
        {name: '茂名', value: 50},
        {name: '嘉兴', value: 51},
        {name: '长春', value: 51},
        {name: '胶州', value: 52},
        {name: '银川', value: 52},
        {name: '张家港', value: 52},
        {name: '三门峡', value: 53},
        {name: '锦州', value: 54},
        {name: '南昌', value: 54},
        {name: '柳州', value: 54},
        {name: '三亚', value: 54},
        {name: '自贡', value: 56},
        {name: '吉林', value: 56},
        {name: '阳江', value: 57},
        {name: '泸州', value: 57},
        {name: '西宁', value: 57},
        {name: '宜宾', value: 58},
        {name: '呼和浩特', value: 58},
        {name: '成都', value: 58},
        {name: '大同', value: 58},
        {name: '镇江', value: 59},
        {name: '桂林', value: 59},
        {name: '张家界', value: 59},
        {name: '宜兴', value: 59},
        {name: '北海', value: 60},
        {name: '西安', value: 61},
        {name: '金坛', value: 62},
        {name: '东营', value: 62},
        {name: '牡丹江', value: 63},
        {name: '遵义', value: 63},
        {name: '绍兴', value: 63},
        {name: '扬州', value: 64},
        {name: '常州', value: 64},
        {name: '潍坊', value: 65},
        {name: '重庆', value: 66},
        {name: '台州', value: 67},
        {name: '南京', value: 67},
        {name: '滨州', value: 70},
        {name: '贵阳', value: 71},
        {name: '无锡', value: 71},
        {name: '本溪', value: 71},
        {name: '克拉玛依', value: 72},
        {name: '渭南', value: 72},
        {name: '马鞍山', value: 72},
        {name: '宝鸡', value: 72},
        {name: '焦作', value: 75},
        {name: '句容', value: 75},
        {name: '北京', value: 79},
        {name: '徐州', value: 79},
        {name: '衡水', value: 80},
        {name: '包头', value: 80},
        {name: '绵阳', value: 80},
        {name: '乌鲁木齐', value: 84},
        {name: '枣庄', value: 84},
        {name: '杭州', value: 84},
        {name: '淄博', value: 85},
        {name: '鞍山', value: 86},
        {name: '溧阳', value: 86},
        {name: '库尔勒', value: 86},
        {name: '安阳', value: 90},
        {name: '开封', value: 90},
        {name: '济南', value: 92},
        {name: '德阳', value: 93},
        {name: '温州', value: 95},
        {name: '九江', value: 96},
        {name: '邯郸', value: 98},
        {name: '临安', value: 99},
        {name: '兰州', value: 99},
        {name: '沧州', value: 100},
        {name: '临沂', value: 103},
        {name: '南充', value: 104},
        {name: '天津', value: 105},
        {name: '富阳', value: 106},
        {name: '泰安', value: 112},
        {name: '诸暨', value: 112},
        {name: '郑州', value: 113},
        {name: '哈尔滨', value: 114},
        {name: '聊城', value: 116},
        {name: '芜湖', value: 117},
        {name: '唐山', value: 119},
        {name: '平顶山', value: 119},
        {name: '邢台', value: 119},
        {name: '德州', value: 120},
        {name: '济宁', value: 120},
        {name: '荆州', value: 127},
        {name: '宜昌', value: 130},
        {name: '义乌', value: 132},
        {name: '丽水', value: 133},
        {name: '洛阳', value: 134},
        {name: '秦皇岛', value: 136},
        {name: '株洲', value: 143},
        {name: '石家庄', value: 147},
        {name: '莱芜', value: 148},
        {name: '常德', value: 152},
        {name: '保定', value: 153},
        {name: '湘潭', value: 154},
        {name: '金华', value: 157},
        {name: '岳阳', value: 169},
        {name: '长沙', value: 175},
        {name: '衢州', value: 177},
        {name: '廊坊', value: 193},
        {name: '菏泽', value: 194},
        {name: '合肥', value: 229},
        {name: '武汉', value: 273},
        {name: '大庆', value: 279}
    ];
    var convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
            var geoCoord = geoCoordMap[data[i].name];
            if (geoCoord) {
                res.push({
                    name: data[i].name,
                    value: geoCoord.concat(data[i].value)
                });
            }
        }
        return res;
    };
//地图容器
    var chart = echarts.init(document.getElementById('map3D'));
//34个省、市、自治区的名字拼音映射数组
    var provinces = {
        //23个省
        "台湾": "taiwan",
        "河北": "hebei",
        "山西": "shanxi",
        "辽宁": "liaoning",
        "吉林": "jilin",
        "黑龙江": "heilongjiang",
        "江苏": "jiangsu",
        "浙江": "zhejiang",
        "安徽": "anhui",
        "福建": "fujian",
        "江西": "jiangxi",
        "山东": "shandong",
        "河南": "henan",
        "湖北": "hubei",
        "湖南": "hunan",
        "广东": "guangdong",
        "海南": "hainan",
        "四川": "sichuan",
        "贵州": "guizhou",
        "云南": "yunnan",
        "陕西": "shanxi1",
        "甘肃": "gansu",
        "青海": "qinghai",
        //5个自治区
        "新疆": "xinjiang",
        "广西": "guangxi",
        "内蒙古": "neimenggu",
        "宁夏": "ningxia",
        "西藏": "xizang",
        //4个直辖市
        "北京": "beijing",
        "天津": "tianjin",
        "上海": "shanghai",
        "重庆": "chongqing",
        //2个特别行政区
        "香港": "xianggang",
        "澳门": "aomen"
    };

//直辖市和特别行政区-只有二级地图，没有三级地图
    var special = ["北京", "天津", "上海", "重庆", "香港", "澳门"];
    var mapdata = [];
//绘制全国地图
    $.getJSON('/static/map/china.json', function (data) {
        d = [];
        for (var i = 0; i < data.features.length; i++) {
            d.push({
                name: data.features[i].properties.name
            })
        }
        mapdata = d;
        //注册地图
        echarts.registerMap('china', data);
        //绘制地图
        renderMap('china', d);
    });

//地图点击事件
    chart.on('click', function (params) {
        console.log(params);
        if (params.name in provinces) {
            //如果点击的是34个省、市、自治区，绘制选中地区的二级地图
            $.getJSON('/static/map/province/' + provinces[params.name] + '.json', function (data) {
                echarts.registerMap(params.name, data);
                var d = [];
                for (var i = 0; i < data.features.length; i++) {
                    d.push({
                        name: data.features[i].properties.name
                    })
                }
                renderMap(params.name, d);
            });
        } else if (params.seriesName in provinces) {
            //如果是【直辖市/特别行政区】只有二级下钻
            if (special.indexOf(params.seriesName) >= 0) {
                renderMap('china', mapdata);
            } else {
                //显示县级地图
                $.getJSON('/static/map/city/' + cityMap[params.name] + '.json', function (data) {
                    /*echarts.registerMap(params.name, data)*/
                    renderMap(params.name,data);
                    var d = [];
                    for (var i = 0; i < data.features.length; i++) {
                        d.push({
                            name: data.features[i].properties.name
                        })
                    }
                    renderMap(params.name, d);
                });
            }
        } else {
            renderMap('china', mapdata);
        }
    });

//初始化绘制全国地图配置
    var option = {
        backgroundColor: 'rgba(0,0,0,0)',
        /*title: {
            //text: '中国地图',
            left: 'center',
            textStyle: {
                color: '#fff',
                fontSize: 16,
                fontWeight: 'normal',
                fontFamily: "Microsoft YaHei"
            }
           /!* subtextStyle: {
                color: '#ccc',
                fontSize: 13,
                fontWeight: 'normal',
                fontFamily: "Microsoft YaHei"
            }*!/
        },*/
        tooltip: {
            trigger: 'item',
            formatter: '{b}'
        },
        toolbox: {
            show: false,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                dataView: {readOnly: false},
                restore: {},
                saveAsImage: {}
            },
            iconStyle: {
                normal: {
                    color: '#fff'
                }
            }
        },
        serize:{
            zoom:2.2
        },
        animationDuration: 1000,
        animationEasing: 'cubicOut',
        animationDurationUpdate: 1000

    };

    function renderMap(name, arr) {
        //option.title.subtext = name;
        option.series = [
            {
                backgroundColor:'rgba(0,0,0,0)',
                map: name,
                type: 'map3D',
                roam: false,
                zlevel: 3,
                regionHeight: 1.5,
                nameMap: {
                    'china': '中国'
                },
                groundPlane: {          // 地面可以让整个组件有个“摆放”的地方，从而使整个场景看起来更真实，更有模型感。
                    show: true,                // 是否显示地面。[ default: false ]
                    color: 'rgba(0,0,0,0)'          // 地面颜色。[ default: '#aaa' ]
                },
                viewControl: {          // 用于鼠标的旋转，缩放等视角控制。
                    projection: 'perspective',      // 投影方式，默认为透视投影'perspective'，也支持设置为正交投影'orthographic'。
                    autoRotate: false,              // 是否开启视角绕物体的自动旋转查看。[ default: false ]
                    autoRotateDirection: 'cw',      // 物体自传的方向。默认是 'cw' 也就是从上往下看是顺时针方向，也可以取 'ccw'，既从上往下看为逆时针方向。
                    autoRotateSpeed: 10,            // 物体自传的速度。单位为角度 / 秒，默认为10 ，也就是36秒转一圈。
                    autoRotateAfterStill: 3,        // 在鼠标静止操作后恢复自动旋转的时间间隔。在开启 autoRotate 后有效。[ default: 3 ]
                    damping: 0,                     // 鼠标进行旋转，缩放等操作时的迟滞因子，在大于等于 1 的时候鼠标在停止操作后，视角仍会因为一定的惯性继续运动（旋转和缩放）。[ default: 0.8 ]
                    rotateSensitivity: 1,           // 旋转操作的灵敏度，值越大越灵敏。支持使用数组分别设置横向和纵向的旋转灵敏度。默认为1, 设置为0后无法旋转。   rotateSensitivity: [1, 0]——只能横向旋转； rotateSensitivity: [0, 1]——只能纵向旋转。
                    zoomSensitivity: 1,             // 缩放操作的灵敏度，值越大越灵敏。默认为1,设置为0后无法缩放。
                    panSensitivity: 1,              // 平移操作的灵敏度，值越大越灵敏。默认为1,设置为0后无法平移。支持使用数组分别设置横向和纵向的平移灵敏度
                    panMouseButton: 'left',         // 平移操作使用的鼠标按键，支持：'left' 鼠标左键（默认）;'middle' 鼠标中键 ;'right' 鼠标右键(注意：如果设置为鼠标右键则会阻止默认的右键菜单。)
                    rotateMouseButton: 'left',      // 旋转操作使用的鼠标按键，支持：'left' 鼠标左键;'middle' 鼠标中键（默认）;'right' 鼠标右键(注意：如果设置为鼠标右键则会阻止默认的右键菜单。)

                    distance: 200,                  // [ default: 100 ] 默认视角距离主体的距离，对于 grid3D 和 geo3D 等其它组件来说是距离中心原点的距离,对于 globe 来说是距离地球表面的距离。在 projection 为'perspective'的时候有效。
                    minDistance: 40,                // [ default: 40 ] 视角通过鼠标控制能拉近到主体的最小距离。在 projection 为'perspective'的时候有效。
                    maxDistance: 400,               // [ default: 400 ] 视角通过鼠标控制能拉远到主体的最大距离。在 projection 为'perspective'的时候有效。

                    alpha: 40,                      // 视角绕 x 轴，即上下旋转的角度。配合 beta 可以控制视角的方向。[ default: 40 ]
                    beta: 15,                       // 视角绕 y 轴，即左右旋转的角度。[ default: 0 ]
                    minAlpha: -360,                 // 上下旋转的最小 alpha 值。即视角能旋转到达最上面的角度。[ default: 5 ]
                    maxAlpha: 360,                  // 上下旋转的最大 alpha 值。即视角能旋转到达最下面的角度。[ default: 90 ]
                    minBeta: -360,                  // 左右旋转的最小 beta 值。即视角能旋转到达最左的角度。[ default: -80 ]
                    maxBeta: 360,                   // 左右旋转的最大 beta 值。即视角能旋转到达最右的角度。[ default: 80 ]

                    center: [0, 0, 0],                // 视角中心点，旋转也会围绕这个中心点旋转，默认为[0,0,0]。

                    animation: true,                // 是否开启动画。[ default: true ]
                    animationDurationUpdate: 1000,  // 过渡动画的时长。[ default: 1000 ]
                    animationEasingUpdate: 'cubicInOut'     // 过渡动画的缓动效果。[ default: cubicInOut ]
                },
                light: {                    // 光照相关的设置。在 shading 为 'color' 的时候无效。  光照的设置会影响到组件以及组件所在坐标系上的所有图表。合理的光照设置能够让整个场景的明暗变得更丰富，更有层次。
                    main: {                     // 场景主光源的设置，在 globe 组件中就是太阳光。
                        color: '#2882d2',              //主光源的颜色。[ default: #fff ]
                        intensity: 1.2,             //主光源的强度。[ default: 1 ]
                        shadow: false,              //主光源是否投射阴影。默认关闭。    开启阴影可以给场景带来更真实和有层次的光照效果。但是同时也会增加程序的运行开销。
                        //shadowQuality: 'high',      // 阴影的质量。可选'low', 'medium', 'high', 'ultra' [ default: 'medium' ]
                        alpha: 70,                  // 主光源绕 x 轴，即上下旋转的角度。配合 beta 控制光源的方向。[ default: 40 ]
                        beta: 10                    // 主光源绕 y 轴，即左右旋转的角度。[ default: 40 ]
                    },
                    ambient: {                  // 全局的环境光设置。
                        color: '#fff',              // 环境光的颜色。[ default: #fff ]
                        intensity: 0.5              // 环境光的强度。[ default: 0.2 ]
                    }
                },
                label: {
                    normal: {
                        show: false,
                        textStyle: {
                            color: '#fff',
                            fontSize: 14,
                            backgroundColor: 'transparent'
                        }
                    },
                    emphasis: {
                        show: false,
                        textStyle: {
                            color: '#fff',
                            fontSize: 14
                        }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#2882d2',
                        //borderWidth:0.5,//设置地图每一部分区域的线条；
                        //borderColor:'#fff'
                       /* borderWidth: 0,
                        borderColor: '#1482d2'*/
                    },
                    emphasis: {
                        color: 'lightBlue'
                    }
                },
                data: arr
            }
        ];
        //渲染地图
        chart.setOption(option);
    }

}
drawMap();