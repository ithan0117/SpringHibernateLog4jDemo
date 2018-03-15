<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">

	<root>
		<level value="info" />
		<appender-ref ref="consoleAppender" />
		<appender-ref ref="fileAppender" />
	</root>

	<appender name="consoleAppender" class="org.apache.log4j.ConsoleAppender">
		<param name="target" value="System.out" /><!-- System.out或System.err -->
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="[%d{yyyy/MM/dd HH:mm:ss}][%p][%C-%L] %m%n" />
		</layout>
	</appender>

	<appender name="fileAppender" class="org.apache.log4j.DailyRollingFileAppender">
		<param name="file" value="${catalina.home}/logs/log4j.log" />
		<param name="append" value="true" />
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="[%d{yyyy/MM/dd HH:mm:ss}][%p][%C-%L] %m%n" />
		</layout>
	</appender>

</log4j:configuration>