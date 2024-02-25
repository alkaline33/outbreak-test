package com.rs.cache.loaders;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import com.rs.cache.Cache;
import com.rs.game.player.content.dungeoneering.DungeonUtils;
import com.rs.io.InputStream;

@SuppressWarnings("unused")
public class ObjectDefinitions {

	private static final ConcurrentHashMap<Integer, ObjectDefinitions> objectDefinitions = new ConcurrentHashMap<Integer, ObjectDefinitions>();

	private short[] recolor_src;
	private short[] retexture_src;
	private short[] retexture_dst;

	int[] toObjectIds;
	static int anInt3832;
	int[] anIntArray3833 = null;
	private int anInt3834;
	int anInt3835;
	static int anInt3836;
	private byte aByte3837;
	int anInt3838 = -1;
	boolean aBoolean3839;
	private int anInt3840;
	private int anInt3841;
	static int anInt3842;
	static int anInt3843;
	int anInt3844;
	boolean aBoolean3845;
	static int anInt3846;
	private byte aByte3847;
	private byte aByte3849;
	int anInt3850;
	int anInt3851;
	public boolean secondBool;
	public boolean aBoolean3853;
	int anInt3855;
	public boolean ignoreClipOnAlternativeRoute;
	int anInt3857;
	private byte[] aByteArray3858;
	int[] anIntArray3859;
	int anInt3860;
	String[] options;
	public int configFileId;
	private short[] recolor_dst;
	int anInt3865;
	boolean aBoolean3866;
	boolean aBoolean3867;
	public boolean aBoolean5424;
	private int[] anIntArray3869;
	boolean aBoolean3870;
	public int sizeY;
	boolean aBoolean3872;
	boolean aBoolean3873;
	public int thirdInt;
	private int anInt3875;
	public int animation;
	private int anInt3877;
	private int anInt3878;
	public int anInt5380;
	private int anInt3881;
	private int anInt3882;
	private int anInt3883;
	Object loader;
	private int anInt3889;
	public int sizeX;
	public boolean aBoolean3891;
	int anInt3892;
	public int anInt5382;
	boolean aBoolean3894;
	boolean aBoolean3895;
	int anInt3896;
	int configId;
	public byte[] shapes;
	int anInt3900;
	public String name;
	private int anInt3902;
	int anInt3904;
	int anInt3905;
	boolean aBoolean3906;
	int[] anIntArray3908;
	private byte aByte5363;
	int anInt3913;
	private byte aByte3914;
	private int anInt3915;
	public int[][] models;
	private int anInt3917;
	/**
	 * Object anim shit 1
	 */
	private short[] aShortArray3919;
	/**
	 * Object anim shit 2
	 */
	private short[] aShortArray3920;
	int anInt3921;
	private HashMap<Integer, Object> parameters;
	boolean aBoolean3923;
	boolean aBoolean3924;
	int accessBlockFlag;
	public int id;

	private int[] anIntArray4534;

	private byte[] unknownArray4;

	private byte[] unknownArray3;

	public String getFirstOption() {
		if (options == null || options.length < 1) {
			return "";
		}
		return options[0];
	}

	public String getSecondOption() {
		if (options == null || options.length < 2) {
			return "";
		}
		return options[1];
	}

	public String getOption(int option) {
		if (options == null || options.length < option || option == 0) {
			return "";
		}
		return options[option - 1];
	}

	public String getThirdOption() {
		if (options == null || options.length < 3) {
			return "";
		}
		return options[2];
	}

	public boolean containsOption(int i, String option) {
		if (options == null || options[i] == null || options.length <= i) {
			return false;
		}
		return options[i].equals(option);
	}

	public boolean containsOption(String o) {
		if (options == null) {
			return false;
		}
		for (String option : options) {
			if (option == null) {
				continue;
			}
			if (option.equalsIgnoreCase(o)) {
				return true;
			}
		}
		return false;
	}

	private void decode(InputStream stream, int opcode) {
		// System.out.println(opcode);
		if (opcode != 1 && opcode != 5) {
			if (opcode != 2) {
				if (opcode != 14) {
					if (opcode != 15) {
						if (opcode == 17) { // nocliped
							aBoolean5424 = false;
							anInt5380 = 0;
						} else if (opcode != 18) {
							if (opcode == 19) {
								anInt5382 = stream.readUnsignedByte();
							} else if (opcode == 21) {
								aByte5363 = (byte) 1;
							} else if (opcode != 22) {
								if (opcode != 23) {
									if (opcode != 24) {
										if (opcode == 27) {
											// diff between 2
											// and 1
											anInt5380 = 1;
										} else if (opcode == 28) {
											anInt3892 = stream.readUnsignedByte() << 2;
										} else if (opcode != 29) {
											if (opcode != 39) {
												if (opcode < 30 || opcode >= 35) {
													if (opcode == 40) {
														int i_53_ = stream.readUnsignedByte();
														recolor_src = new short[i_53_];
														recolor_dst = new short[i_53_];
														for (int i_54_ = 0; i_53_ > i_54_; i_54_++) {
															recolor_src[i_54_] = (short) stream.readUnsignedShort();
															recolor_dst[i_54_] = (short) stream.readUnsignedShort();
														}
													} else if (44 == opcode) {
														int i_86_ = (short) stream.readUnsignedShort();
														int i_87_ = 0;
														for (int i_88_ = i_86_; i_88_ > 0; i_88_ >>= 1) {
															i_87_++;
														}
														unknownArray3 = new byte[i_87_];
														byte i_89_ = 0;
														for (int i_90_ = 0; i_90_ < i_87_; i_90_++) {
															if ((i_86_ & 1 << i_90_) > 0) {
																unknownArray3[i_90_] = i_89_;
																i_89_++;
															} else {
																unknownArray3[i_90_] = (byte) -1;
															}
														}
													} else if (opcode == 45) {
														int i_91_ = (short) stream.readUnsignedShort();
														int i_92_ = 0;
														for (int i_93_ = i_91_; i_93_ > 0; i_93_ >>= 1) {
															i_92_++;
														}
														unknownArray4 = new byte[i_92_];
														byte i_94_ = 0;
														for (int i_95_ = 0; i_95_ < i_92_; i_95_++) {
															if ((i_91_ & 1 << i_95_) > 0) {
																unknownArray4[i_95_] = i_94_;
																i_94_++;
															} else {
																unknownArray4[i_95_] = (byte) -1;
															}
														}
													} else if (opcode != 41) { // object
														// anim
														if (opcode != 42) {
															if (opcode != 62) {
																if (opcode != 64) {
																	if (opcode == 65) {
																		anInt3902 = stream.readUnsignedShort();
																	} else if (opcode != 66) {
																		if (opcode != 67) {
																			if (opcode == 69) {
																				accessBlockFlag = stream.readUnsignedByte();
																			} else if (opcode != 70) {
																				if (opcode == 71) {
																					anInt3889 = stream.readShort() << 2;
																				} else if (opcode != 72) {
																					if (opcode == 73) {
																						secondBool = true;
																					} else if (opcode == 74) {
																						ignoreClipOnAlternativeRoute = true;
																					} else if (opcode != 75) {
																						if (opcode != 77 && opcode != 92) {
																							if (opcode == 78) {
																								anInt3860 = stream.readUnsignedShort();
																								anInt3904 = stream.readUnsignedByte();
																							} else if (opcode != 79) {
																								if (opcode == 81) {
																									aByte5363 = (byte) 2;
																									anInt3882 = 256 * stream.readUnsignedByte();
																								} else if (opcode != 82) {
																									if (opcode == 88) {
																										aBoolean3853 = false;
																									} else if (opcode != 89) {
																										if (opcode == 90) {
																											aBoolean3870 = true;
																										} else if (opcode != 91) {
																											if (opcode != 93) {
																												if (opcode == 94) {
																													aByte5363 = (byte) 4;
																												} else if (opcode != 95) {
																													if (opcode != 96) {
																														if (opcode == 97) {
																															aBoolean3866 = true;
																														} else if (opcode == 98) {
																															aBoolean3923 = true;
																														} else if (opcode == 99) {
																															anInt3857 = stream.readUnsignedByte();
																															anInt3835 = stream.readUnsignedShort();
																														} else if (opcode == 100) {
																															anInt3844 = stream.readUnsignedByte();
																															anInt3913 = stream.readUnsignedShort();
																														} else if (opcode != 101) {
																															if (opcode == 102) {
																																anInt3838 = stream.readUnsignedShort();
																															} else if (opcode == 103) {
																																thirdInt = 0;
																															} else if (opcode != 104) {
																																if (opcode == 105) {
																																	aBoolean3906 = true;
																																} else if (opcode == 106) {
																																	int i_55_ = stream.readUnsignedByte();
																																	anIntArray3869 = new int[i_55_];
																																	anIntArray3833 = new int[i_55_];
																																	for (int i_56_ = 0; i_56_ < i_55_; i_56_++) {
																																		anIntArray3833[i_56_] = stream.readBigSmart();
																																		int i_57_ = stream.readUnsignedByte();
																																		anIntArray3869[i_56_] = i_57_;
																																		anInt3881 += i_57_;
																																	}
																																} else if (opcode == 107) {
																																	anInt3851 = stream.readUnsignedShort();
																																} else if (opcode >= 150 && opcode < 155) {
																																	options[opcode + -150] = stream.readString();
																																} else if (opcode != 160) {
																																	if (opcode == 162) {
																																		aByte5363 = (byte) 3;
																																		anInt3882 = stream.readInt();
																																	} else if (opcode == 163) {
																																		aByte3847 = (byte) stream.readByte();
																																		aByte3849 = (byte) stream.readByte();
																																		aByte3837 = (byte) stream.readByte();
																																		aByte3914 = (byte) stream.readByte();
																																	} else if (opcode != 164) {
																																		if (opcode != 165) {
																																			if (opcode != 166) {
																																				if (opcode == 167) {
																																					anInt3921 = stream.readUnsignedShort();
																																				} else if (opcode != 168) {
																																					if (opcode == 169) {
																																						aBoolean3845 = true;
																																						// added
																																						// opcode
																																					} else if (opcode == 170) {
																																						int anInt3383 = stream.readUnsignedSmart();
																																						// added
																																						// opcode
																																					} else if (opcode == 171) {
																																						int anInt3362 = stream.readUnsignedSmart();
																																						// added
																																						// opcode
																																					} else if (opcode == 173) {
																																						int anInt3302 = stream.readUnsignedShort();
																																						int anInt3336 = stream.readUnsignedShort();
																																						// added
																																						// opcode
																																					} else if (opcode == 177) {
																																						boolean ub = true;
																																						// added
																																						// opcode
																																					} else if (opcode == 178) {
																																						int db = stream.readUnsignedByte();
																																					} else if (opcode == 189) {
																																						boolean bloom = true;
																																					} else if (opcode >= 190 && opcode < 196) {
																																						if (anIntArray4534 == null) {
																																							anIntArray4534 = new int[6];
																																							Arrays.fill(anIntArray4534, -1);
																																						}
																																						anIntArray4534[opcode - 190] = stream.readUnsignedShort();
																																					} else if (opcode == 249) {
																																						int length = stream.readUnsignedByte();
																																						if (parameters == null) {
																																							parameters = new HashMap<Integer, Object>(length);
																																						}
																																						for (int i_60_ = 0; i_60_ < length; i_60_++) {
																																							boolean bool = stream.readUnsignedByte() == 1;
																																							int i_61_ = stream.read24BitInt();
																																							if (!bool) {
																																								parameters.put(i_61_, stream.readInt());
																																							} else {
																																								parameters.put(i_61_, stream.readString());
																																							}

																																						}
																																					}
																																				} else {
																																					aBoolean3894 = true;
																																				}
																																			} else {
																																				anInt3877 = stream.readShort();
																																			}
																																		} else {
																																			anInt3875 = stream.readShort();
																																		}
																																	} else {
																																		anInt3834 = stream.readShort();
																																	}
																																} else {
																																	int i_62_ = stream.readUnsignedByte();
																																	anIntArray3908 = new int[i_62_];
																																	for (int i_63_ = 0; i_62_ > i_63_; i_63_++) {
																																		anIntArray3908[i_63_] = stream.readUnsignedShort();
																																	}
																																}
																															} else {
																																anInt3865 = stream.readUnsignedByte();
																															}
																														} else {
																															anInt3850 = stream.readUnsignedByte();
																														}
																													} else {
																														aBoolean3924 = true;
																													}
																												} else {
																													aByte5363 = (byte) 5;
																													anInt3882 = stream.readShort();
																												}
																											} else {
																												aByte5363 = (byte) 3;
																												anInt3882 = stream.readUnsignedShort();
																											}
																										} else {
																											aBoolean3873 = true;
																										}
																									} else {
																										aBoolean3895 = false;
																									}
																								} else {
																									aBoolean3891 = true;
																								}
																							} else {
																								anInt3900 = stream.readUnsignedShort();
																								anInt3905 = stream.readUnsignedShort();
																								anInt3904 = stream.readUnsignedByte();
																								int i_64_ = stream.readUnsignedByte();
																								anIntArray3859 = new int[i_64_];
																								for (int i_65_ = 0; i_65_ < i_64_; i_65_++) {
																									anIntArray3859[i_65_] = stream.readUnsignedShort();
																								}
																							}
																						} else {
																							configFileId = stream.readUnsignedShort();
																							if (configFileId == 65535) {
																								configFileId = -1;
																							}
																							configId = stream.readUnsignedShort();
																							if (configId == 65535) {
																								configId = -1;
																							}
																							int i_66_ = -1;
																							if (opcode == 92) {
																								i_66_ = stream.readBigSmart();
																							}
																							int i_67_ = stream.readUnsignedByte();
																							toObjectIds = new int[i_67_ - -2];
																							for (int i_68_ = 0; i_67_ >= i_68_; i_68_++) {
																								toObjectIds[i_68_] = stream.readBigSmart();
																							}
																							toObjectIds[i_67_ + 1] = i_66_;
																						}
																					} else {
																						anInt3855 = stream.readUnsignedByte();
																					}
																				} else {
																					anInt3915 = stream.readShort() << 2;
																				}
																			} else {
																				anInt3883 = stream.readShort() << 2;
																			}
																		} else {
																			anInt3917 = stream.readUnsignedShort();
																		}
																	} else {
																		anInt3841 = stream.readUnsignedShort();
																	}
																} else {
																	// 64
																	aBoolean3872 = false;
																}
															} else {
																aBoolean3839 = true;
															}
														} else {
															int i_69_ = stream.readUnsignedByte();
															aByteArray3858 = new byte[i_69_];
															for (int i_70_ = 0; i_70_ < i_69_; i_70_++) {
																aByteArray3858[i_70_] = (byte) stream.readByte();
															}
														}
													} else { // object anim?
														int i_71_ = stream.readUnsignedByte();
														aShortArray3920 = new short[i_71_];
														aShortArray3919 = new short[i_71_];
														for (int i_72_ = 0; i_71_ > i_72_; i_72_++) {
															aShortArray3920[i_72_] = (short) stream.readUnsignedShort();
															aShortArray3919[i_72_] = (short) stream.readUnsignedShort();
														}
													}
												} else {
													options[-30 + opcode] = stream.readString();
												}
											} else {
												// 39
												anInt3840 = stream.readByte() * 5;
											}
										} else {// 29
											anInt3878 = stream.readByte();
										}
									} else {
										animation = stream.readBigSmart();
									}
								} else {
									thirdInt = 1;
								}
							} else {
								aBoolean3867 = true;
							}
						} else {
							aBoolean5424 = false;
						}
					} else {
						// 15
						sizeY = stream.readUnsignedByte();
					}
				} else {
					// 14
					sizeX = stream.readUnsignedByte();
				}
			} else {
				name = stream.readString();
			}
		} else {
			boolean aBoolean1162 = false;
			if (opcode == 5 && aBoolean1162) {
				skipReadModelIds(stream);
			}
			int i_73_ = stream.readUnsignedByte();
			models = new int[i_73_][];
			shapes = new byte[i_73_];
			for (int i_74_ = 0; i_74_ < i_73_; i_74_++) {
				shapes[i_74_] = (byte) stream.readByte();
				int i_75_ = stream.readUnsignedByte();
				models[i_74_] = new int[i_75_];
				for (int i_76_ = 0; i_75_ > i_76_; i_76_++) {
					models[i_74_][i_76_] = stream.readBigSmart();
				}
			}
			if (opcode == 5 && !aBoolean1162) {
				skipReadModelIds(stream);
			}
		}
	}

	private void decodeOSRS(InputStream buffer, int opcode) {
		if (1 == opcode) {
			int num_shapes = buffer.readUnsignedByte();
			shapes = new byte[num_shapes];
			models = new int[num_shapes][];
			for (int shape_index = 0; shape_index < num_shapes; shape_index++) {
				models[shape_index] = new int[] { buffer.readUnsignedShort() + 200_000 };
				shapes[shape_index] = (byte) buffer.readByte();
			}
		} else if (opcode == 2) {
			name = buffer.readString();
		} else if (opcode == 5) {
			shapes = new byte[] { 10 };
			int num_models = buffer.readUnsignedByte();
			models = new int[1][num_models];
			for (int index = 0; index < num_models; index++) {
				models[0][index] = buffer.readUnsignedShort() + 200_000;
			}
		} else if (14 == opcode) {
			sizeX = buffer.readUnsignedByte();
		} else if (opcode == 15) {
			sizeY = buffer.readUnsignedByte();
		} else if (opcode == 17) {
			anInt5380 = 0;
			aBoolean5424 = false;
		} else if (opcode == 18) {
			aBoolean5424 = false;
		} else if (19 == opcode) {
			anInt5382 = buffer.readUnsignedByte();
		} else if (21 == opcode) {
			aByte5363 = (byte) 1;
		} else if (opcode == 22) {
			aBoolean3867 = true;
		} else if (opcode == 23) {
			thirdInt = 1;
		} else if (24 == opcode) {
			int i_5_ = buffer.readUnsignedShort();
			if (i_5_ == 65535) {
				animation = -1;
			} else {
				i_5_ += 30_000;
				animation = i_5_;
			}
		} else if (opcode == 27) {
			anInt5380 = 1;
		} else if (28 == opcode) {
			anInt3892 = buffer.readUnsignedByte() << 2;
		} else if (opcode == 29) {
			anInt3878 = buffer.readByte();
		} else if (39 == opcode) {
			anInt3840 = buffer.readByte();
		} else if (opcode >= 30 && opcode < 35) {
			options[opcode - 30] = buffer.readString();
			if (options[opcode - 30].equalsIgnoreCase("Hidden")) {
				options[opcode - 30] = null;
			}
		} else if (opcode == 40) {
			int i_6_ = buffer.readUnsignedByte();
			recolor_src = new short[i_6_];
			recolor_dst = new short[i_6_];
			for (int i_7_ = 0; i_7_ < i_6_; i_7_++) {
				recolor_src[i_7_] = (short) buffer.readUnsignedShort();
				recolor_dst[i_7_] = (short) buffer.readUnsignedShort();
			}
		} else if (opcode == 41) {
			int i_8_ = buffer.readUnsignedByte();
			retexture_src = new short[i_8_];
			retexture_dst = new short[i_8_];
			for (int i_9_ = 0; i_9_ < i_8_; i_9_++) {
				retexture_src[i_9_] = (short) buffer.readUnsignedShort();
				retexture_dst[i_9_] = (short) buffer.readUnsignedShort();
			}
		} else if (opcode == 42) {
			int i_10_ = buffer.readUnsignedByte();
			aByteArray3858 = new byte[i_10_];
			for (int i_11_ = 0; i_11_ < i_10_; i_11_++) {
				aByteArray3858[i_11_] = (byte) buffer.readByte();
			}
		} else if (opcode == 62) {
			aBoolean3839 = true;
		} else if (64 == opcode) {
			aBoolean3872 = false;
		} else if (65 == opcode) {
			anInt3902 = buffer.readUnsignedShort();
		} else if (66 == opcode) {
			anInt3841 = buffer.readUnsignedShort();
		} else if (opcode == 67) {
			anInt3917 = buffer.readUnsignedShort();
		} else if (opcode == 68) {
			buffer.readUnsignedShort();
		} else if (opcode == 69) {
			accessBlockFlag = buffer.readUnsignedByte();
		} else if (opcode == 70) {
			anInt3883 = buffer.readShort() << 2;
		} else if (opcode == 71) {
			anInt3889 = buffer.readShort() << 2;
		} else if (opcode == 72) {
			anInt3915 = buffer.readShort() << 2;
		} else if (opcode == 73) {
			secondBool = true;
		} else if (opcode == 74) {
			ignoreClipOnAlternativeRoute = true;
		} else if (opcode == 75) {
			anInt3855 = buffer.readUnsignedByte();
		} else if (77 == opcode || 92 == opcode) {
			configFileId = buffer.readUnsignedShort();
			if (65535 == configFileId) {
				configFileId = -1;
			}
			configId = buffer.readUnsignedShort();
			if (65535 == configId) {
				configId = -1;
			}
			int i_12_ = -1;
			if (92 == opcode) {
				i_12_ = buffer.readUnsignedShort();
				if (i_12_ == 65535) {
					i_12_ = -1;
				} else {
					i_12_ += 200_000;
				}
			}
			int i_13_ = buffer.readUnsignedByte();
			toObjectIds = new int[2 + i_13_];
			for (int i_14_ = 0; i_14_ <= i_13_; i_14_++) {
				toObjectIds[i_14_] = buffer.readUnsignedShort();
				if (toObjectIds[i_14_] == 65535) {
					toObjectIds[i_14_] = -1;
				} else {
					toObjectIds[i_14_] += 200_00;
				}
			}
			toObjectIds[i_13_ + 1] = i_12_;
		} else if (opcode == 78) {
			anInt3860 = buffer.readUnsignedShort();
			anInt3904 = buffer.readUnsignedByte();
		} else if (opcode == 79) {
			anInt3900 = buffer.readUnsignedShort();
			anInt3905 = buffer.readUnsignedShort();
			anInt3904 = buffer.readUnsignedByte();
			int i_15_ = buffer.readUnsignedByte();
			anIntArray3859 = new int[i_15_];
			for (int i_16_ = 0; i_16_ < i_15_; i_16_++) {
				anIntArray3859[i_16_] = buffer.readUnsignedShort();
			}
		} else if (81 == opcode) {
			aByte5363 = (byte) 2;
			anInt3882 = buffer.readUnsignedByte() * 256;
		} else if (opcode == 82) {
			aBoolean3891 = true;
		} else if (opcode == 249) {
			int i_23_ = buffer.readUnsignedByte();
			if (parameters == null) {
				parameters = new HashMap<>(i_23_);
			}
			for (int i_25_ = 0; i_25_ < i_23_; i_25_++) {
				boolean bool = buffer.readUnsignedByte() == 1;
				int i_26_ = buffer.read24BitInt();
				parameters.put(i_26_, bool ? buffer.readString() : buffer.readInt());
			}
		}
	}

	private void skipReadModelIds(InputStream stream) {
		int length = stream.readUnsignedByte();
		for (int index = 0; index < length; index++) {
			stream.skip(1);
			int length2 = stream.readUnsignedByte();
			for (int i = 0; i < length2; i++) {
				stream.readBigSmart();
			}
		}
	}

	private void decode(InputStream stream) {
		for (;;) {
			int opcode = stream.readUnsignedByte();
			if (opcode == 0) {
				break;
			}
			decode(stream, opcode);
		}
	}

	private void decodeOSRS(InputStream stream) {
		for (;;) {
			int opcode = stream.readUnsignedByte();
			if (opcode == 0) {
				break;
			}
			decodeOSRS(stream, opcode);
		}
	}

	private ObjectDefinitions() {
		anInt3835 = -1;
		anInt3860 = -1;
		configFileId = -1;
		aBoolean3866 = false;
		anInt3851 = -1;
		anInt3865 = 255;
		aBoolean3845 = false;
		aBoolean3867 = false;
		anInt3850 = 0;
		anInt3844 = -1;
		anInt3881 = 0;
		anInt3857 = -1;
		aBoolean3872 = true;
		anInt3882 = -1;
		anInt3834 = 0;
		options = new String[5];
		anInt3875 = 0;
		aBoolean3839 = false;
		anIntArray3869 = null;
		sizeY = 1;
		thirdInt = -1;
		anInt3883 = 0;
		aBoolean3895 = true;
		anInt3840 = 0;
		aBoolean3870 = false;
		anInt3889 = 0;
		aBoolean3853 = true;
		secondBool = false;
		anInt5380 = 2;
		aBoolean5424 = true;
		ignoreClipOnAlternativeRoute = false;
		anInt3855 = -1;
		anInt3878 = 0;
		anInt3904 = 0;
		sizeX = 1;
		animation = -1;
		aBoolean3891 = false;
		anInt3905 = 0;
		name = "null";
		anInt3913 = -1;
		aBoolean3906 = false;
		aBoolean3873 = false;
		aByte3914 = (byte) 0;
		anInt3915 = 0;
		anInt3900 = 0;
		anInt5382 = -1;
		aBoolean3894 = false;
		aByte5363 = (byte) 0;
		anInt3921 = 0;
		anInt3902 = 128;
		configId = -1;
		anInt3877 = 0;
		accessBlockFlag = 0;
		anInt3892 = 64;
		aBoolean3923 = false;
		aBoolean3924 = false;
		anInt3841 = 128;
		anInt3917 = 128;
	}

	final void method3287() {
		if (anInt5382 == -1) {
			anInt5382 = 0;
			if (shapes != null && shapes.length == 1 && shapes[0] == 10) {
				anInt5382 = 1;
			}
			for (int i_13_ = 0; i_13_ < 5; i_13_++) {
				if (options[i_13_] != null) {
					anInt5382 = 1;
					break;
				}
			}
		}
		if (anInt3855 == -1) {
			anInt3855 = anInt5380 != 0 ? 1 : 0;
		}
	}

	private static int getArchiveId(int i_0_) {
		return i_0_ >>> -1135990488;
	}

	public static ObjectDefinitions getObjectDefinitions(int id) {
		ObjectDefinitions def = objectDefinitions.get(id);
		if (def == null) {
			def = new ObjectDefinitions();
			def.id = id;
			byte[] data = Cache.STORE.getIndexes()[16].getFile(id >>> 8, id & 0xff);
			if (data != null) {
				if (id >= 200_000) {
					def.decodeOSRS(new InputStream(data));
				} else {
					def.decode(new InputStream(data));
				}
			}
			def.method3287();
			if (def.name.equalsIgnoreCase("bank booth") || def.name.equalsIgnoreCase("counter")) {
				def.ignoreClipOnAlternativeRoute = false;
				def.aBoolean5424 = true;
				if (def.anInt5380 == 0) {
					def.anInt5380 = 1;
				}
			} else if (DungeonUtils.isDoor(id)) {
				def.ignoreClipOnAlternativeRoute = false;
				def.aBoolean5424 = true;
				if (def.anInt5380 == 0) {
					def.anInt5380 = 1;
				}
			}
			if (def.ignoreClipOnAlternativeRoute) {
				def.aBoolean5424 = false;
				def.anInt5380 = 0;
			}
			objectDefinitions.put(id, def);
		}
		return def;
	}

	public int getClipType() {
		return anInt5380;
	}

	public boolean isProjectileCliped() {
		return aBoolean5424;
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public static void clearObjectDefinitions() {
		objectDefinitions.clear();
	}

	/**
	 * Prints all fields in this class.
	 */
	public void printFields() {
		for (Field field : getClass().getDeclaredFields()) {
			if ((field.getModifiers() & 8) != 0) {
				continue;
			}
			try {
				System.out.println(field.getName() + ": " + getValue(field));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		System.out.println("-- end of " + getClass().getSimpleName() + " fields --");
	}

	public int getAccessBlockFlag() {
		return accessBlockFlag;
	}

	private Object getValue(Field field) throws Throwable {
		field.setAccessible(true);
		Class<?> type = field.getType();
		if (type == int[][].class) {
			return Arrays.toString((int[][]) field.get(this));
		} else if (type == int[].class) {
			return Arrays.toString((int[]) field.get(this));
		} else if (type == byte[].class) {
			return Arrays.toString((byte[]) field.get(this));
		} else if (type == short[].class) {
			return Arrays.toString((short[]) field.get(this));
		} else if (type == double[].class) {
			return Arrays.toString((double[]) field.get(this));
		} else if (type == float[].class) {
			return Arrays.toString((float[]) field.get(this));
		} else if (type == Object[].class) {
			return Arrays.toString((Object[]) field.get(this));
		}
		return field.get(this);
	}

}