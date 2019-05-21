$(function () {
    $('.myedit').popover({
           trigger:'click', //触发方式
           title:"是否跳转至管理系统？",//设置 弹出框 的标题
           html: true, // 为true的话，data-content里就能放html代码了
           content: function () {
            return $('#popcontent').html();
        }//这里可以直接写字符串，也可以 是一个函数，该函数返回一个字符串；
        });

    $('.myedit').popover({
        trigger:'click', //触发方式
        title:"是否跳转至管理系统？",//设置 弹出框 的标题
        html: true, // 为true的话，data-content里就能放html代码了
        content: function () {
            return $('#popcontent').html();
        }//这里可以直接写字符串，也可以 是一个函数，该函数返回一个字符串；
    });

})

function popok() {
    window.open("http://localhost:8088/index");
}

function popcancel() {
    $('.myedit').popover('hide');
    $('.mydel').popover('hide');
}

function showChart(t, y, type) {
    $('#figureModal').modal('toggle');
    var yname;
    if (type == 'p')
        yname = "压强P(MPa)";
    if (type == 'f')
        yname = "推力F(kN)";
    drawChart(t.split(',').map(Number),y.split(',').map(Number),yname);
}



function detailSingleRec(id) {
    window.open("http://localhost:8088/getSrmExpById/"+id);
}

function delSingleRec(id) {

}

function editSingleRec(srmName) {

}

function drawChart(xdata, ydata, yname){
    var chart = Highcharts.chart('figcontainer', {
        title: {
            text: '内弹道'
        },
        boost: {
            useGPUTranslations: true
        },
        subtitle: {
            text: '原始数据'
        },
        xAxis: {
            categories: xdata
        },
        yAxis: {
            title: {
                text: yname
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },

        series: [{
            name: yname,
            data: ydata
        }],
        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        }
    });
}

