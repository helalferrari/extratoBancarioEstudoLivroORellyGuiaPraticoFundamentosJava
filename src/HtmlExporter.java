public class HtmlExporter implements Exporter {

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = " <!doctype html public \"http://www.w3.org/1999/xhtml\" >";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction  Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is: " + summaryStatistics.getSum() + "</strong></li>";
        result += "<li><strong>The average is: " + summaryStatistics.getAverage() + "</strong></li>";
        result += "<li><strong>The max is: " + summaryStatistics.getMax() + "</strong></li>";
        result += "<li><strong>The min is: " + summaryStatistics.getMin() + "</strong></li>";
        result += "</ul>";
        result += "</body></html>";

        return result;
    }
}
