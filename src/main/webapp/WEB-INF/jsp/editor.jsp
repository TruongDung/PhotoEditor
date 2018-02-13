<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper>
	<jsp:attribute name="title">
		Editor
	</jsp:attribute>

    <jsp:body>
    
	    <link rel="stylesheet" href="<c:url value='/resources/css/editor.css'/>" />
	    
	    <div class="pageContainer">
		    <div id="uploadDiv">
				<label id="lblUpload"><span class="fa fa-upload fa-2x"></span><input type="file" id="uploadedFile" /></label>
			</div>
			
			<main>
				<div id="uploadImageHint">
                    <p>Upload your image to start editing<p/>
                </div>
                
				<div id="editor">
					<div>
						<ul id="editMode">
							<li class="btn btn-warning" id="preset">Preset</li>
							<li class="btn btn-default" id="custom">Custom</li>
						</ul>
					</div>
					
					<div id="editorControls">
						<p>
							<span class="factor-label">Blur </span><input type="range" id="blur" class="slider"
									min="0" max="10" value="0"
									data-filter="blur" 
									data-unit="px" />
						</p>
						<p>
							<span class="factor-label">Brightness </span><input type="range" id="brightness" class="slider"
											min="30" max="200" value="100"
											data-filter="brightness"
											data-unit="%" />
						</p>
						<p>
							<span class="factor-label">Contrast </span><input type="range" id="contrast" class="slider"
										min="30" max="200" value="100"
										data-filter="contrast"
										data-unit="%" />
						</p>
						<p>
							<span class="factor-label">Grayscale </span><input type="range" id="grayscale" class="slider"
										min="0" max="100" value="0"
										data-filter="grayscale" 
										data-unit="%" />
						</p>
						<p>
							<span class="factor-label">Hue Rotate </span><input type="range" id="hueRotate" class="slider"
											min="0" max="350" value="0"
											data-filter="hue-rotate"
											data-unit="deg" />
						</p>
						<p>
							<span class="factor-label">Invert </span><input type="range" id="invert" class="slider"
										min="0" max="100" value="0"
										data-filter="invert" 
										data-unit="%" />
						</p>
						<p>
							<span class="factor-label">Opacity </span><input type="range" id="opacity" class="slider"
										min="40" max="100" value="100"
										data-filter="opacity"
										data-unit="%" />
						</p>
						<p>
							<span class="factor-label">Saturate </span><input type="range" id="saturate" class="slider"
										min="0" max="250" value="100"
										data-filter="saturate"
											data-unit="%" />
						</p>
						<p>
							<span class="factor-label">Sepia </span><input type="range" id="sepia" class="slider"
										min="0" max="100" value="0"
										data-filter="sepia"
										data-unit="%" />
						</p>
						<div>
							
						</div>
					</div>
					
					<div id="editorPresets">
						<!-- 
							Willow
							Walden
							Valencia
							
							Toaster
							Sierra
							Nashville
							
							Lo-Fi
							Kelvin
							Rise
						
						-->
						
						<div>
							<div id="willow" class="sampleImage willow"></div>
							<div id="y1977" class="sampleImage y1977"></div>
							<div id="rise" class="sampleImage rise"></div>
		
						</div>
						<div>
							<p class="presetName">Willow</p>
							<p class="presetName">1977</p>
							<p class="presetName">Rise</p>
						</div>
						
						<div>
							<div id="sierra" class="sampleImage sierra"></div>
							<div id="valencia" class="sampleImage valencia"></div>
							<div id="loFi" class="sampleImage lofi"></div>
						</div>
						<div>
							<p class="presetName">Sierra</p>
							<p class="presetName">Valencia</p>
							<p class="presetName">Lo-Fi</p>
						</div>
						
						<div>
							<div id="earlyBird" class="sampleImage earlybird"></div>
							<div id="walden" class="sampleImage walden"></div>
							<div id="xPro2" class="sampleImage xpro2"></div>
							
							
						</div>
						<div>
							<p class="presetName">Early Bird</p>
							<p class="presetName">Walden</p>
							<p class="presetName">XPro-2</p>
						</div>
						
						<div>
							<div id="nashville" class="sampleImage nashville"></div>
							<div id="toaster" class="sampleImage toaster"></div>
							<div id="kelvin" class="sampleImage kelvin"></div>
						</div>
						<div>
							<p class="presetName">Nashville</p>
							<p class="presetName">Toaster</p>
							<p class="presetName">Kelvin</p>
						</div>
						
					</div>
					
					<div id="processDiv">
						<div>
							<button id="btnReset" class="btn bottom-command btn-info">Reset</button></br>
							<a id="lnkDownload" href="#" target="_blank" download="editedImage.jpg" class="btn btn-primary bottom-command">Download</a><br/>
							<button id="btnSaveModified" class="btn btn-primary bottom-command">Save</button>
						</div>
					</div>
					
				</div>
			
				<div id="imageStage">
					<br/>
					<img id="imageToEdit" alt="Image to edit"/>
				</div>
				
				
			</main>
		</div>
		<script src="<c:url value='/resources/js/editor.js'/>"></script>
    </jsp:body>
</t:wrapper>