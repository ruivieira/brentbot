package org.ruivieira.brentbot;

import com.ircclouds.irc.api.Callback;
import com.ircclouds.irc.api.IRCApi;
import com.ircclouds.irc.api.IRCApiImpl;
import com.ircclouds.irc.api.IServerParameters;
import com.ircclouds.irc.api.domain.IRCServer;
import com.ircclouds.irc.api.state.IIRCState;

import java.util.Arrays;
import java.util.List;

/**
 * User: ruivieira
 * Date: 15/12/13
 * Time: 15:29
 */
public class Bot {

    private final IRCApi api;


    public Bot() {

        this.api = new IRCApiImpl(false);

}

    public static IServerParameters getServerParams(final String aNickname, final List<String> aAlternativeNicks, final String aRealname, final String aIdent,
                                                     final String aServerName, final Boolean aIsSSLServer)
    {
        return new IServerParameters()
        {
            @Override
            public IRCServer getServer()
            {
                return new IRCServer(aServerName, aIsSSLServer);
            }

            @Override
            public String getRealname()
            {
                return aRealname;
            }

            @Override
            public String getNickname()
            {
                return aNickname;
            }

            @Override
            public String getIdent()
            {
                return aIdent;
            }

            @Override
            public List<String> getAlternativeNicknames()
            {
                return aAlternativeNicks;
            }
        };
    }

    public void connect(IServerParameters server, Callback<IIRCState> callback) {
        api.connect(server, callback);

    }

}
