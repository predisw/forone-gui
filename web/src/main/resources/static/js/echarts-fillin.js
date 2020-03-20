  function appendDataToChart(fundInfo, chartTemplate){
    console.log(fundInfo)
    chartTemplate.legend.data.push(fundInfo.fundName)
    chartTemplate.xAxis.data = fundInfo.time

    var chartItem =
        {
              name: '',
              type: 'line',
              data: [],
              markPoint: {
                  data: [
                      {type: 'max', name: '最大值'},
                      {type: 'min', name: '最小值'}
                  ]
              }
        }

    chartItem.name = fundInfo.fundName
    chartItem.data = fundInfo.fluctuate
    chartTemplate.series.push(chartItem)
  }