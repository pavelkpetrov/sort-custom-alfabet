package com.qittiq.order;

import com.qittiq.order.serivce.Sorter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


/**
 * Class to sort ordered string according to the custom alphabet
 */
@Slf4j
public class App 
{
    private final static String C_PARAM_ARB = "arb";
    private final static String C_PARAM_ALFABET = "alfabet";

    public static void main( String[] args )
    {

        try
        {
            CommandLine cl = parseOptions(args);
            String result = Sorter.getSorter().apply(
                    cl.getOptionValue(C_PARAM_ARB),
                    cl.getOptionValue(C_PARAM_ALFABET));
            log.info( "Sort result: {}", result );

        }
        catch (ParseException exception)
        {
            log.error(exception.getMessage(), exception);
        }

    }

    private static CommandLine parseOptions(String[] args) throws ParseException{
        CommandLine commandLine;

        Options options = new Options();
        CommandLineParser parser = new DefaultParser();

        options.addOption(C_PARAM_ALFABET, true, "Arbitrary alphabet string"); // Bei false gibt spaeter null
        options.addOption(C_PARAM_ARB, true, "Arbitrary string"); // Bei false gibts spaeter null

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "java -jar App-jar-with-dependencies.jar", options );

        commandLine = parser.parse(options, args);
        logOption(commandLine, C_PARAM_ARB);
        logOption(commandLine, C_PARAM_ALFABET);

        return commandLine;

    }

    private static void logOption(CommandLine commandLine, String optName){
        if (commandLine.hasOption(optName)) {
            log.info("Option {} is present.  The value is: {}", optName, commandLine.getOptionValue(optName));
        }
    }
}
