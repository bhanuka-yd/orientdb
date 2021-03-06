/*
 *
 *  *  Copyright 2010-2016 OrientDB LTD (http://orientdb.com)
 *  *
 *  *  Licensed under the Apache License, Version 2.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtain a copy of the License at
 *  *
 *  *       http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *  Unless required by applicable law or agreed to in writing, software
 *  *  distributed under the License is distributed on an "AS IS" BASIS,
 *  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  See the License for the specific language governing permissions and
 *  *  limitations under the License.
 *  *
 *  * For more information: http://orientdb.com
 *
 */
package com.orientechnologies.orient.core.storage.fs;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;

/**
 * Interface to represent low-level File access.
 *
 * @author Luca Garulli (l.garulli--(at)--orientdb.com)
 */
public interface OFile {
  /**
   * Opens the file.
   */
  void open();

  /**
   * Creates the file.
   */
  void create() throws IOException;

  /**
   * Closes the file.
   */
  void close();

  /**
   * Deletes the file.
   */
  void delete() throws IOException;

  void synch();

  void read(long iOffset, byte[] iDestBuffer, int iLength) throws IOException;

  int readInt(long iLogicalPosition) throws IOException;

  long readLong(long iOffset) throws IOException;

  void writeInt(long iOffset, int iValue) throws IOException;

  void writeLong(long iOffset, long iValue) throws IOException;

  void writeByte(long iOffset, byte iValue) throws IOException;

  void write(long iOffset, byte[] iSourceBuffer) throws IOException;

  /**
   * Shrink the file content (filledUpTo attribute only)
   */
  void shrink(final long iSize) throws IOException;

  String getName();

  String getPath();

  void renameTo(Path newFile) throws IOException;

  /**
   * Replaces the file content with the content of the provided file.
   *
   * @param newContentFile the new content file to replace the content with.
   */
  void replaceContentWith(Path newContentFile) throws IOException;

  long allocateSpace(final int size) throws IOException;

  long getFileSize();

  String toString();

  boolean isOpen();

  boolean exists();

  void read(long iOffset, byte[] iData, int iLength, int iArrayOffset) throws IOException;

  void write(long iOffset, byte[] iData, int iSize, int iArrayOffset) throws IOException;

  void read(long offset, ByteBuffer buffer, boolean throwOnEof) throws IOException;

  void read(long offset, ByteBuffer[] buffers, boolean throwOnEof) throws IOException;

  void write(long offset, ByteBuffer buffer) throws IOException;

  void write(long offset, ByteBuffer[] buffers) throws IOException;
}
