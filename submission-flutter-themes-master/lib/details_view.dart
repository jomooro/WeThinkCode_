import 'package:flutter/material.dart';
import 'details_view.dart';

class DetailsView extends StatefulWidget {
  const DetailsView({Key? key, required this.currentTheme}) : super(key: key);

  @override
  State<DetailsView> createState() => _DetailsViewState();

  final ThemeData currentTheme;
}

class _DetailsViewState extends State<DetailsView> {
  @override
  Widget build(BuildContext context) {
    return Theme(
      data: widget.currentTheme,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Details'),
        ),
        body: Padding(
          padding: const EdgeInsets.all(16.0),
          child: ListView(
            children: _buildListWidgets(context),
          ),
        ),
      ),
    );
  }

  List<Widget> _buildListWidgets(BuildContext context) {
    final theme = Theme.of(context).textTheme;

    return [
      Text('This is a Headline4', style: theme.headline4),
      Text('This is medium body text', style: theme.bodyText2),
      Text('This is small body text', style: theme.bodyText1),
      ..._buildListTiles(),
      ElevatedButton(
        onPressed: () {},
        style: ElevatedButton.styleFrom(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(32.0),
          ),
        ),
        child: const Text("Primary Color Button"),
      ),
      OutlinedButton(
        onPressed: () {},
        style: ElevatedButton.styleFrom(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(32.0),
          ),
        ),
        child: const Text('Outline Color Button'),
      ),
      ..._buildCards(),
    ];
  }

  List<Widget> _buildListTiles() {
    return List.generate(4, (i) => ListTile(
      leading: const Icon(Icons.alarm),
      title: Text('List Tile Title $i'),
      subtitle: Text('An interesting subtitle $i'),
    ));
  }

  List<Widget> _buildCards() {
    return List.generate(5, (i) => Card(
      child: ListTile(
        leading: const Icon(Icons.image),
        title: Text('Some Card Title $i'),
        subtitle: Text('A short description $i'),
      ),
    ));
  }
}