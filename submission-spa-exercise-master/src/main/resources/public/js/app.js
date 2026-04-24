window.addEventListener('load', () => {
  const app = $('#app');
  
  const defaultTemplate = Handlebars.compile($('#default-template').html());
  const dictionaryTemplate = Handlebars.compile($('#dictionary-template').html());
  const thesaurusTemplate = Handlebars.compile($('#thesaurus-template').html());
  const synonymsTemplate = Handlebars.compile($('#synonyms-template').html());
  const antonymsTemplate = Handlebars.compile($('#antonyms-template').html());


  const router = new Router({
    mode:'hash',
    root:'index.html',
    page404: (path) => {
      const html = defaultTemplate();
      app.html(html);
    }
  });
  
  router.add('/dictionary', async () => {
    html = dictionaryTemplate();
    app.html(html);
    lookupWord();
  });
  
  router.add('/thesaurus', async () => {
    html = thesaurusTemplate();
    app.html(html);
  });

  router.add('/synonyms', async () => {
    html = synonymsTemplate();
    app.html(html);
    lookupSynonyms();
  });  

  router.add('/antonyms', async () => {
    html = antonymsTemplate();
    app.html(html);
    lookupAntonyms();
  });  
  
  router.addUriListener();
  
  $('a').on('click', (event) => {
    event.preventDefault();
    const target = $(event.target);
    const href = target.attr('href');
    const path = href.substring(href.lastIndexOf('/'));
    router.navigateTo(path);
  });
  
  router.navigateTo('/');
  });
  // end::router[]
  
  function lookupWord() {                                                        
    const form = document.getElementById("form");
    form.addEventListener("submit", (event) => {
        event.preventDefault();

        const data = new FormData(event.target);
        const word = data.get("lookup");

        const options = {
            method: 'GET',
        };

        document.getElementById('results').innerHTML = `<p>Searching for <em>${word}'</em>...</p>`;

        fetch(`https://api.dictionaryapi.dev/api/v2/entries/en/${word}`, options)
            .then(response => response.json())
            .then(data => {
                data = {
                    word: data[0].word,
                    phonetic: data[0].phonetic,
                    audio: data[0].phonetics[0].audio,
                    partOfSpeech: data[0].meanings[0].partOfSpeech,
                    definitions: data[0].meanings[0].definitions,
                    meanings :data[0].meanings
                };
                const template = document.getElementById('results-template').innerText;
                const compiledFunction = Handlebars.compile(template);
                document.getElementById('results').innerHTML = compiledFunction(data);
            });
    });;
}

function lookupSynonyms() {
  const form = document.getElementById("form");
  form.addEventListener("submit", (event) => {
      event.preventDefault();

      const data = new FormData(event.target);
      const word = data.get("lookup");

      const options = {
          method: 'GET',
      };

      document.getElementById('results').innerHTML = `<p>Searching for <em>${word}'</em>...</p>`;

      fetch(`https://api.dictionaryapi.dev/api/v2/entries/en/${word}`, options)
          .then(response => response.json())
          .then(data => {
              data = {
                  word: data[0].word,
                  synonyms: data[0].meanings[0].synonyms
              };
              const template = document.getElementById('synonyms-results-template').innerText;
              const compiledFunction = Handlebars.compile(template);
              document.getElementById('results').innerHTML = compiledFunction(data);
          });
  });;
}  

function lookupAntonyms() {
  const form = document.getElementById("form");
  form.addEventListener("submit", (event) => {
      event.preventDefault();

      const data = new FormData(event.target);
      const word = data.get("lookup");

      const options = {
          method: 'GET',
      };

      document.getElementById('results').innerHTML = `<p>Searching for <em>${word}'</em>...</p>`;

      fetch(`https://api.dictionaryapi.dev/api/v2/entries/en/${word}`, options)
          .then(response => response.json())
          .then(data => {
              data = {
                  word: data[0].word,
                  antonyms: [...new Set(data[0].meanings[1].antonyms)]
              };
              console.log(data.antonyms);
              const template = document.getElementById('antonyms-results-template').innerText;
              const compiledFunction = Handlebars.compile(template);
              document.getElementById('results').innerHTML = compiledFunction(data);
          });
  });;
}