import 'dart:io';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';

class PhotoView extends StatefulWidget {
  const PhotoView({super.key, required this.title});

  final String title;

  @override
  State<PhotoView> createState() => _PhotoViewState();
}

class _PhotoViewState extends State<PhotoView> {
  XFile? imageFile;

  @override
  void initState() {
    super.initState();
  }

  Future<void> _getImage(ImageSource source) async {
    final XFile? pickedImage = await ImagePicker().pickImage(source: source);
    setState(() {
      imageFile = pickedImage;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          const SizedBox(height: 16.0),
          ElevatedButton(
            onPressed: () => _getImage(ImageSource.gallery),
            child: const Text('Select Photo from Gallery'),
          ),
          const SizedBox(
            height: 16.0,
          ),
          ElevatedButton(
            onPressed: () => _getImage(ImageSource.camera),
            child: const Text('Select from Camera'),
          ),
          const SizedBox(height: 30.0),
          Center(
            child: imageFile == null
                ? const Text('Select image using above buttons.')
                : Image.memory(
              File(imageFile!.path).readAsBytesSync(),
              width: 400,
              height: 400,
              fit: BoxFit.fitWidth,
            ),
          ),
        ],
      ),
    );
  }
}