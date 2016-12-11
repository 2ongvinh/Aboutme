/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckfinder.com/license
*/

CKFinder.customConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// config.skin = 'v1';
	 config.language = 'vi';
	config.filebrowserBrowseUrl = '/Aboutme/admin/js/ckfinder/ckfinder.html';
	 config.filebrowserImageBrowseUrl = '/Aboutme/admin/js/ckfinder/ckfinder.html?type=Images';
	 config.filebrowserFlashBrowseUrl = '/Aboutme/admin/js/ckfinder/ckfinder.html?type=Flash';
	 config.filebrowserUploadUrl = '/Aboutme/admin/js/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
	 config.filebrowserImageUploadUrl = '/Aboutme/admin/js/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
	 config.filebrowserFlashUploadUrl = '/Aboutme/admin/js/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';

};
