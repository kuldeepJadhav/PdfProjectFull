<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:template match="root">

		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="my-page">
					<fo:region-body margin="10px" />
				</fo:simple-page-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="my-page">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<fo:table background-color="white">
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell width="200px" text-align="left">
										<fo:block>
											<fo:external-graphic
												src="http://localhost:8080/pdfproject/public/images/logo.jpg" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="400px" text-align="left"
										font-weight="normal" font-style="italic" color="#B8E65C"
										font-size="40px" padding="50px 0px 10px 20px">
										<fo:block>
											<xsl:value-of select="company/company-name" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
					</fo:block>
					<fo:block-container width="150px" margin-top="20px"
						margin-bottom="1px" text-align="center" margin-left="3px" padding="5px"
						background-color="#336699" color="white">
						<fo:block>
							About Us
						</fo:block>
					</fo:block-container>
					<fo:block>
						<fo:table margin-left="3px">
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell background-color="#D6EBFF"
										text-align="left" line-height="1.5" font-weight="normal"
										padding="10px" font-size="10px" color="#339966">
										<fo:block>
											<xsl:value-of select="company/company-info" />
											
										</fo:block>
										<fo:block>
											&#x260E; 933442111
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
					</fo:block>

					<!-- <fo:block> <fo:table background-color="#F3F9FF" margin-top="20px"> 
						<fo:table-body> <fo:table-row> <fo:table-cell text-align="left" font-weight="bold"> 
						<fo:block> Machine -Logo </fo:block> </fo:table-cell> <fo:table-cell text-align="left" 
						font-weight="bold"> <fo:block> <xsl:value-of select="machine/machine-name" 
						/> </fo:block> </fo:table-cell> </fo:table-row> </fo:table-body> </fo:table> 
					
					
					
										</fo:block> -->
					
					<fo:block>
						<fo:table margin-left="3px">
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell  width="400px" height="400px">
										<fo:block>
										<fo:external-graphic width="90%" height="90%"  
												src="http://localhost:8080/pdfproject/public/images/machine.jpg" />
										</fo:block>	
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
					</fo:block>			
					
					
					<fo:block-container width="150px" margin-top="20px"
						margin-bottom="1px" text-align="center" margin-left="3px" padding="5px"
						background-color="#336699" color="white">
						<fo:block>
							About The Machine/Machine Category
						</fo:block>
					</fo:block-container>
					<fo:block>
						<fo:table margin-left="3px">
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell background-color="#D6EBFF"
										text-align="left" font-weight="normal" padding="10px"
										font-size="10px" color="#339966">
										<fo:block-container line-height="1.5"
											padding="2px" font-size="13px" font-weight="bold">
											<fo:block>
												<xsl:value-of select="machine/machine-name" />
											</fo:block>
										</fo:block-container>
										<fo:block-container line-height="1.5">
											<fo:block>
												<xsl:value-of select="machine/machine-info" />
											</fo:block>
										</fo:block-container>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="#D6EBFF"
										text-align="left" font-weight="normal" padding="10px"
										font-size="10px" color="#339966">
										<fo:block-container line-height="1.5"
											padding="2px" font-size="13px" font-weight="bold">
											
											<fo:block>
												<xsl:value-of select="machine/machine-category/machine-category-name" />
											</fo:block>
											
										</fo:block-container>
										<fo:block-container line-height="1.5">
											<fo:block>
												<xsl:value-of select="machine/machine-category/machine-category-description" />
											</fo:block>
										</fo:block-container>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
					</fo:block>



					<fo:block-container width="150px" margin-top="10px"
						margin-bottom="0px" text-align="center" margin-left="3px" padding="5px"
						background-color="#336699" color="white">
						<fo:block>
							Accesories List
						</fo:block>
					</fo:block-container>

					<fo:block>
						<fo:table background-color="white" margin-top="0px">
							<fo:table-body>
								<fo:table-row>
								
								
									<fo:table-cell color="white" text-align="center"
										margin-top="0px">
										<fo:block-container margin-left="3px"
											margin-top="0px" margin-right="3px" margin-bottom="3px"
											padding-top="20px" background-color="#A3CC29" height="40px">
											<fo:block>
												Name
											</fo:block>
										</fo:block-container>
									</fo:table-cell>



									<fo:table-cell color="white" text-align="center">
										<fo:block-container padding-top="20px"
											margin-left="3px" margin-top="0px" margin-right="3px"
											margin-bottom="3px" background-color="#A3CC29" height="40px">
											<fo:block>
												Description
											</fo:block>
										</fo:block-container>
									</fo:table-cell>


									<fo:table-cell color="white" text-align="center">
										<fo:block-container padding-top="20px"
											margin-left="3px" margin-top="0px" margin-right="3px"
											margin-bottom="3px" background-color="#A3CC29" height="40px">
											<fo:block>
												Cost
											</fo:block>
										</fo:block-container>
									</fo:table-cell>
								</fo:table-row>
								<xsl:for-each select="machine/machine-category/accessory">
									<fo:table-row>
										<xsl:if test="row-index mod 2 =0">
											<fo:table-cell font-size="8px" text-align="left"
												font-weight="normal">
												<fo:block-container padding-top="10px"
													padding-left="5px" margin="3px" overflow="hidden" height="40px"
													background-color="#F3F9FF">

													<fo:block>
														<xsl:value-of select="name" />
													</fo:block>
												</fo:block-container>
											</fo:table-cell>
											<fo:table-cell font-size="8px" text-align="left"
												font-weight="normal">
												<fo:block-container padding-top="10px"
													padding-left="5px" margin="3px" overflow="hidden" height="40px"
													background-color="#F3F9FF">
													<fo:block>
														<xsl:value-of select="description" />
													</fo:block>
												</fo:block-container>
											</fo:table-cell>
											<fo:table-cell font-size="8px" text-align="left"
												font-weight="normal">
												<fo:block-container padding-top="10px"
													padding-left="5px" margin="3px" height="40px"
													background-color="#F3F9FF">
													<fo:block>
														<xsl:value-of select="cost" /> (<xsl:value-of select="type" />)
													</fo:block>
												</fo:block-container>
											</fo:table-cell>
										</xsl:if>

										<xsl:if test="row-index mod 2 !=0">
											<fo:table-cell font-size="8px" text-align="left"
												font-weight="normal">
												<fo:block-container padding-top="10px"
													padding-left="5px" margin="3px" height="40px"
													background-color="#F0FFC2">
													<fo:block>
														 <xsl:value-of select="name" />
													</fo:block>
												</fo:block-container>
											</fo:table-cell>
											<fo:table-cell font-size="8px" text-align="left"
												font-weight="normal">
												<fo:block-container padding-top="10px"
													overflow="scroll" padding-left="5px" margin="3px" height="40px"
													background-color="#F0FFC2">
													<fo:block>
														<xsl:value-of select="description" />
														<!-- It provides Day/Week/Month view for the events It provides 
															Day/Week/Month view for the events It provides Day/Week/Month view for the 
															events It provides Day/Week/Month view for the events It provides Day/Week/Month 
															view for the events It provides Day/Week/Month view for the events -->
													</fo:block>
												</fo:block-container>
											</fo:table-cell>
											<fo:table-cell text-align="left" font-weight="normal"
												font-size="8px">
												<fo:block-container padding-top="10px"
													padding-left="5px" margin="3px" height="40px"
													background-color="#F0FFC2">
													<fo:block>
														<xsl:value-of select="cost" /> (<xsl:value-of select="type" />)
													</fo:block>
												</fo:block-container>
											</fo:table-cell>
										</xsl:if>
									</fo:table-row>

								</xsl:for-each>
								<fo:table-row>
									<fo:table-cell background-color="#D6EBFF">
										<fo:block-container 
											 margin-bottom="0px" text-align="center"
											margin-left="3px" padding="5px" color="black" font-size="15px">
											<fo:block>
												Grand Cost : 3000$
											</fo:block>
										</fo:block-container>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
					</fo:block>




				</fo:flow>
			</fo:page-sequence>
		</fo:root>
		<!-- TODO: Auto-generated template -->
	</xsl:template>
</xsl:stylesheet>