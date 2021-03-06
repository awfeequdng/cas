package org.apereo.cas.memcached.kryo.serial;

import lombok.val;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;

/**
 * Kryo serializer for {@link URL}.
 *
 * @author Jerome Leleu
 * @since 4.0.0
 */
@Slf4j
public class URLSerializer extends Serializer<URL> {
    @Override
    @SneakyThrows
    public URL read(final Kryo kryo, final Input input, final Class<? extends URL> aClass) {
        val url = kryo.readObject(input, String.class);
        return new URL(url);
    }

    @Override
    public void write(final Kryo kryo, final Output output, final URL url) {
        kryo.writeObject(output, url.toExternalForm());
    }

}
